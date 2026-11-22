# 环境搭建与恢复手册

本文件用于「换机器、换终端、隔一个月后」按步骤复原开发环境。**只看本文件即可，不依赖聊天记录。**

## 一、固定环境清单

| 项 | 版本 / 位置 |
|---|---|
| 操作系统 | Windows |
| JDK | Temurin 21 (LTS)，`C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot` |
| JAVA_HOME | 同上（用户环境变量，已设置） |
| IDE | IntelliJ IDEA 2026.1.3（中文界面） |
| Git | 2.54.0，`C:\Program Files\Git\cmd`（已加入用户 PATH） |
| Git 身份 | `pengfeiyang2006` / `feipfy@qq.com`（全局配置） |
| MySQL | **仅保留一个实例：服务名 `MySQL`，端口 3306**（安装路径 `C:\tools\mysql`） |
| 数据库 | `device_db`（utf8mb4），表 `device` |
| 仓库 | `D:\Java\java-roadmap` |
| 远程 | https://github.com/pengfeiyang2006/java-roadmap （main） |

> 约定：**所有数据库操作统一走 3306。**
> 端口对照：服务 `MySQL`（`C:\tools\mysql`）= 3306，**在用**；服务 `MySQL80`（官方安装）= 3307，已停止并设为手动启动，不要连。

## 二、从零恢复步骤

### 1. 拉取代码

```powershell
git clone https://github.com/pengfeiyang2006/java-roadmap.git "D:\Java\java-roadmap"
```

### 2. 打开 IDEA 并标记源码根

1. `File → Open` 选择仓库目录
2. 右键 `w01-javase` → **Mark Directory as → Sources Root**
3. `File → Project Structure → Project SDK` 选 JDK 21

### 3. 放置 JDBC 驱动

jar 不进仓库（`.gitignore` 已忽略 `*.jar`），需要手动下载到 `lib\`：

```powershell
New-Item -ItemType Directory -Force "D:\Java\java-roadmap\lib"
Invoke-WebRequest "https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.4.0/mysql-connector-j-8.4.0.jar" `
  -OutFile "D:\Java\java-roadmap\lib\mysql-connector-j-8.4.0.jar"
```

然后 IDEA 里右键该 jar → **Add as Library**。

### 4. 准备数据库

确认服务在跑：`Get-Service MySQL80` 应为 `Running`。

用 MySQL 命令行执行 `w01-javase/day13/device.sql`（把 `select version();` 那行去掉不影响）：

```powershell
mysql -h 127.0.0.1 -P 3306 -u root -p --default-character-set=utf8mb4 < "D:\Java\java-roadmap\w01-javase\day13\device.sql"
```

### 5. 验证环境

```powershell
cd "D:\Java\java-roadmap\w01-javase"
javac -encoding UTF-8 -cp "..\lib\mysql-connector-j-8.4.0.jar" -d "..\out\production\java-roadmap" day14\JdbcDemo.java
java -cp "..\out\production\java-roadmap;..\lib\mysql-connector-j-8.4.0.jar" day14.JdbcDemo
```

预期输出：

```
连接成功
1 | 数控机床 | 一号车间 | 正常运行
2 | 激光切割机 | 二号车间 | 待维修
```

## 三、仓库规范

- 源码根：`w01-javase`，每天一个目录 `dayNN`，首行 `package dayNN;`
- 一个 `.java` 只允许一个 `public class`，且与文件名一致
- `.gitignore` 必须包含：`.idea/`、`*.class`、`out/`、`*.jar`
- 依赖 jar 放 `lib/`，不进版本库
- commit message 格式：`dayNN: 做了什么`，不写「更新」「修改」

## 四、每日流程（固定，不跳步）

```
敲代码 → 遇到问题提问 → 记录问答 → 整理成 dayNN/xxxNotes.md → commit + push → 才进下一天
```

## 五、JDBC 报错速查

| 报错 | 出错阶段 | 先查什么 |
|---|---|---|
| `ClassNotFoundException` | 加载驱动 | jar 是否添加、类名是否为 `com.mysql.cj.jdbc.Driver` |
| `Access denied` | 建立连接 | 账号密码、`using password: YES/NO` |
| `Unknown database` | 建立连接 | URL 末尾库名拼写 |
| `Connection refused` | 建立连接 | MySQL 服务是否启动、端口是否 3306 |
| `SQLSyntaxErrorException` 1064/1146/1054 | 执行 SQL | SQL 文本、表名、列名 |

## 六、已知的机器级配置（不要再踩）

- `hosts` 文件曾被写入大量 `127.0.0.1 github.com` 条目，导致 git push 失败；已清理并固定为可用 IP，备份在 `C:\Windows\System32\drivers\etc\hosts.bak.20261119`
- 曾同时运行两个 MySQL 实例：`MySQL`（3306，在用）与 `MySQL80`（3307，已停用并设为手动启动）
