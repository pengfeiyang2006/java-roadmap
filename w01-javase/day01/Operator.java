package day01;

public class Operator {
    public static void main(String[] args) {
        System.out.println(7 / 2); //3
        System.out.println(7.0 / 2);//3.5
        System.out.println(7 % 2);//1
        int i = 5;
        System.out.println(i++);//5
        System.out.println(i);//6
        int j = 5;
        System.out.println(++j);//6
        System.out.println(j);//6
        System.out.println(3 > 2);//t
        System.out.println(3 > 2 && 5 < 1);//f
        int a = 10;
        boolean r = (3 > 5) && (a++ > 0);
        System.out.println("r=" + r + ",a=" + a);//r=false,a=11(错误改正a=10)
        int score = 59;
        System.out.println(score >= 60 ? "及格" : "不及格");
    }
}

