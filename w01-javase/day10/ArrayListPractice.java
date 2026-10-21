package day10;

import java.sql.SQLOutput;
import java.util.ArrayList;
public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("Java");
        list.add("MySQL");
        list.add("Spring");
        System.out.println("第一个；"+list.get(0));
        System.out.println("大小："+list.get(1));
        for(String s:list){
            System.out.println(s);
        }
        list.remove("Java");
        System.out.println(list);
    }
}
