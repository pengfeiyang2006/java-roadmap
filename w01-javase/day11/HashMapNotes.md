# Day11 HashMap 集合笔记

## 一、什么是 HashMap

键值对存储：一个 key 对应一个 value（学号→姓名、用户ID→用户）。给 key 查 value，O(1) 级别的查找速度。

## 二、基本使用（四个方法记死）

```java
import java.util.HashMap;

HashMap<String, String> map = new HashMap<>();

map.put("202401", "张三");   // 存：key + value
map.get("202402");           // 取：按 key 拿 value
map.size();                  // 键值对个数
map.containsKey("202402");   // 是否包含某个 key
```

## 三、key 为什么唯一

HashMap 底层：用 key 计算位置（hash），value 存到那个位置。key 一样 → 位置一样 → 往同一格子放两次货，后面的盖住前面的。所以 key 重复 = 修改，不是新增。

## 四、put 覆盖机制

```java
map.put("202401", "张三");     // 存 张三
map.put("202401", "张三三");   // 同一个 key → 覆盖 → 值是 张三三
map.get("202401");             // 返回 "张三三"
```

**记法**：key 相同 = 修改；key 不同 = 新增。

## 五、两种遍历方式

```java
// 方式1：keySet —— 先拿所有 key，再逐个 get（多一次查找）
for (String key : map.keySet()) {
    System.out.println(key + ">" + map.get(key));
}

// 方式2：entrySet —— 一次拿键值对，key 和 value 都在手上（推荐，更快）
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ">" + entry.getValue());
}
```

**区别**：keySet 每次循环要用 key 再查一遍 value；entrySet 直接拿到键值对。数据量大时 entrySet 更快，面试问遍历用哪个 → entrySet。

## 六、List vs Map

| | ArrayList（List） | HashMap（Map） |
|---|---|---|
| 结构 | 一排，按顺序/下标 | 键值对，一一对应 |
| 元素 | 可以有重复 | key 不能重复 |
| 查找 | 按下标 | 按 key |
| 删除 | remove(值/下标) | remove(key) |

**本质**：List 管顺序，Map 管唯一对应。
