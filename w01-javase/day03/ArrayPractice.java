package day03;

import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};
        System.out.println("length=" + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        int sum = 0, max = arr[0];
        for (int x : arr) {

            sum += x;
            if (x > max) {
                max = x;
            }

        }
        System.out.println("sum=" + sum);
        System.out.println("max=" + max);
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        System.out.println(Arrays.toString(arr));

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
