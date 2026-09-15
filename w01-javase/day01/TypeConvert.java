package day01;

public class TypeConvert {
    public static void main(String[] args) {
        int a = 100;
        double b = a;
        System.out.println("自动转换 int->double: " + b);


        double x = 9.99;
        int y = (int) x;
        System.out.println("强制转换 double->int: " + y);
    }
}
