package day2;

import java.util.Scanner;

public class ControlFlow {
    public static void main(String[] args) {
        int score;
        Scanner sc = new Scanner(System.in);
        score = sc.nextInt();
        if (score >= 90) {
            System.out.println("good");
        } else if (score >= 60) {
            System.out.println("pass");
        } else {
            System.out.println("bad");
        }
        int day;
        Scanner sc2 = new Scanner(System.in);
        day = sc2.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("other");
        }
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum=" + sum);
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }
}
