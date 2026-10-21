# Day10 ArrayList 集合笔记

## 一、什么是 ArrayList

动态数组。数组长度固定（`int[] arr = new int[3]`），ArrayList 长度自动增长，自带增删查方法。

## 二、基本使用（四个方法记死）

```java
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();

list.add("Java");          // 添加元素
list.get(0);               // 按下标取元素
list.size();               // 元素个数
list.remove("MySQL");      // 删除元素
```

遍历（增强 for）：

```java
for (String s : list) {
    System.out.println(s);
}
```

## 三、泛型 `<String>` 是什么

类型参数，限定集合只能装指定类型：

```java
ArrayList<String> list = new ArrayList<>();
list.add("Java");        // 可以
list.add(123);           // 编译报错
```

- 不写泛型：什么都能装，取出来是 Object，要强转，易出错
- 写泛型：编译时卡死类型，加错直接报错，取出不用转

好处：把运行时才爆的类型错误提前到编译时。后端到处都是 `List<User>`、`Map<String, Object>`，标准写法。

## 四、remove 按值删 vs 按下标删

`remove` 有两个重载，看参数类型区分：

```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(10); nums.add(20); nums.add(30);

nums.remove(1);    // 按下标删：删索引1 → 删掉20
nums.remove(Integer.valueOf(30));  // 按值删：删值为30的元素
```

关键陷阱：**传 int 是按下标，传对象才按值**：

```java
nums.remove(10);    // ❌ 10 被当下标，越界报错
nums.remove(Integer.valueOf(10));   // ✅ 删值为10的元素
```

String 集合里 `remove("MySQL")` 是字符串对象不是下标，天然按值删，无歧义。

## 五、数组 vs ArrayList

| | 数组 | ArrayList |
|---|---|---|
| 长度 | 固定 | 自动扩容 |
| 添加/删除 | 麻烦 | add/remove 自带 |
| 取元素 | arr[i] | get(i) |
| 类型 | 任意类型 | 必须泛型 |
| 性能 | 更快 | 稍慢（有开销） |
