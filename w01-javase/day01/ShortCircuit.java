package day01;

public class ShortCircuit {
    public static void main(String[] args) {
        int a = 10;
        boolean r1 = (3 > 5) && (a++ > 0);
        System.out.println("r=" + r1 + ",a=" + a);
        int b = 10;
        boolean r2 = (3 > 5) & (b++ > 0);
        System.out.println("r2=" + r2 + ",b=" + b);
    }
}
