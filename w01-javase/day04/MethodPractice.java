package day04;

public class MethodPractice {
    public static int add(int a, int b) {
        return a + b;
    }
    public static void printRectangle(int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static int add(int a, int b, int c){
        return a + b + c;
    }
    public static double add(double a,double b){
        return a + b;
    }
    public static void main(String[] args){
        System.out.println(add(3,5));
        System.out.println(add(3,5,7));
        System.out.println(add(3.5,2.5));
        printRectangle(3,5);
    }
}
