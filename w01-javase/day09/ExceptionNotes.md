# Day9 异常处理笔记

## 一、什么是异常

程序运行时出现的错误（不是编译错误）。异常会中断程序，用异常处理机制可以让程序继续执行，而不是直接崩掉。

## 二、五个核心关键字

| 关键字 | 作用 |
|--------|------|
| `try` | 包裹可能出错的代码 |
| `catch` | 捕获并处理异常 |
| `finally` | 无论是否异常都执行（关闭资源用） |
| `throw` | 在代码里主动抛出一个异常对象 |
| `throws` | 方法签名上声明该方法可能抛出异常 |

## 三、基本结构

```java
try {
    // 可能出错的代码
} catch (异常类型 e) {
    // 出错后的处理
} finally {
    // 一定执行的代码
}
```

## 四、异常对象 e 的两个方法

- `e.getMessage()`：返回错误描述（字符串），如 `/ by zero`
- `e.printStackTrace()`：打印完整错误堆栈（哪一行出错、调用链），调试用

## 五、catch 匹配规则

- 每个 catch 只接自己类型的异常
- 可以写多个 catch，从上到下匹配
- `catch (Exception e)` 能接住所有异常（Exception 是所有异常的父类）

```java
try {
    // ...
} catch (ArrayIndexOutOfBoundsException e) {
    // 越界走这里
} catch (ArithmeticException e) {
    // 除零走这里
} catch (Exception e) {
    // 兜底：其他异常走这里
}
```

## 六、throw 和 throws 的区别

- `throw`：方法内部，主动抛出一个异常对象（`throw new Exception("提示")`）
- `throws`：方法签名上，声明调用者这个方法可能抛异常（`public void f() throws Exception`）

```java
public static void checkAge(int age) throws Exception {
    if (age < 18) {
        throw new Exception("未成年，不能进入");
    }
}
```

## 七、常见异常（面试高频）

| 异常 | 含义 |
|------|------|
| `NullPointerException` | 空指针，对象为 null 还调方法（Java 最常见） |
| `ArrayIndexOutOfBoundsException` | 数组下标越界 |
| `ArithmeticException` | 算术异常，如整数除零 |
| `ClassCastException` | 类型转换错误 |
| `NumberFormatException` | 数字格式化错误，如把 "abc" 转成 int |

## 八、代码技巧

- **Ctrl + Alt + T**：选中代码后自动包裹 try-catch（Surround With）
- **Alt + Enter**：类实现接口/继承抽象类时，自动生成需要重写的方法
