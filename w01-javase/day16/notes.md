---
AIGC:
    Label: "1"
    ContentProducer: 001191440300708461136T1XGW3
    ProduceID: 3b123e55ee4bd742904d2b274558d21c_6bfd6ac8eb1111f1a20652540072b1e8
    ReservedCode1: ciyoEme/6cFk6uZqcKA9ksCZrNHyRNdWBoNY0U85y9xVIngZlUWghVhmYNZrgeQXKqu4+Z9XjAh42yABgZZUFKrdVILhDw9hJtx+pc6mOrrOt1aZ9frRW5bQoNpeOhlau/nJnuISwq4KPTxKch5tZQ9wV+zCSDz3gYhs1q5hC9zZwVQC8alXeZN9y3k=
    ContentPropagator: 001191440300708461136T1XGW3
    PropagateID: 3b123e55ee4bd742904d2b274558d21c_6bfd6ac8eb1111f1a20652540072b1e8
    ReservedCode2: ciyoEme/6cFk6uZqcKA9ksCZrNHyRNdWBoNY0U85y9xVIngZlUWghVhmYNZrgeQXKqu4+Z9XjAh42yABgZZUFKrdVILhDw9hJtx+pc6mOrrOt1aZ9frRW5bQoNpeOhlau/nJnuISwq4KPTxKch5tZQ9wV+zCSDz3gYhs1q5hC9zZwVQC8alXeZN9y3k=
---

# Day16 笔记：Maven 接管 jar 依赖

1. Maven 用「坐标」唯一定位一个 jar，坐标由三个标签组成。
2. groupId：组织/公司域名倒写，表示项目归属，如 com.mysql（对应 com/mysql 目录）。
3. artifactId：项目或模块名，如 mysql-connector-j，是 jar 文件名的前缀。
4. version：版本号，如 8.4.0，决定使用哪个发行版。
5. 三者合起来 com.mysql : mysql-connector-j : 8.4.0 就是这条依赖的完整坐标。
6. jar 会下载到本地仓库：%USERPROFILE%\.m2\repository\com\mysql\mysql-connector-j\8.4.0\mysql-connector-j-8.4.0.jar。
7. 本机展开即 C:\Users\feipf\.m2\repository\com\mysql\mysql-connector-j\8.4.0\mysql-connector-j-8.4.0.jar。
8. 路径规律：groupId 的点换成目录分隔符 + artifactId + version + artifactId-version.jar。
9. 以后不用手动放 jar：pom.xml 声明坐标后，mvn 自动从中央仓库（或阿里云镜像）下载并缓存进 .m2。
10. 其他项目引用同一坐标会直接复用 .m2 缓存，编译/打包时 Maven 自动把 jar 加入 classpath。
*（内容由AI生成，仅供参考）*
