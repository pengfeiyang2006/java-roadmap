package day09;

public class ExceptionPractice {
    public  static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获异常" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally一定执行");
        }

        try {
            int r = 10 / 0;
            System.out.println(r);
        } catch (ArithmeticException e) {
            System.out.println("除零异常：" + e.getMessage());
            e.printStackTrace();
        }
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkAge(int age) throws Exception{
        if(age<18){
            throw new Exception("未成年，不能入内");
        }
        System.out.println("成年人，可以入内");
    }
}

//ArithmeticException e
//e.getMessage()
//ArithmeticException e
//ArrayIndexOutOfBoundsException e