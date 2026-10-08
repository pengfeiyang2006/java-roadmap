package day05;

class Student{
    private String name;
    private int age;
    private double score;

    public Student(){
    }
    public Student(String name, int age, double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }//构造器

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public double getScore() {return score;}
    public void setScore(double score) {this.score = score;}
    public void introduce(){
        System.out.println("我叫"+name+"，"+age+"岁，成绩"+score);
    }
}
public class OOPPractice {
    public static void main(String[] args) {
        Student s1 =new Student("张三",20,85.5);//类是模板。对象是实例
        s1.introduce();
        Student s2 =new Student();
        s2.setName("李四");
        s2.setAge(21);
        s2.setScore(92.0);
        s2.introduce();
        System.out.println(s1.getName()+"的成绩是"+s1.getScore());
    }
}
//为什么要封装？
//1. 防垃圾数据：setter 里加校验，age 不能是负数、score 不能超 100；
//2. 控制读写权限：只读字段只给 getter 不给 setter（比如学生 ID，创建后锁死）；
