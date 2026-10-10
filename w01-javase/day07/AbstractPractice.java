package day07;

abstract class Shape {
    public abstract double area();

    public void printArea() {
        System.out.println("面积是" + area());
    }
}

class Circle extends Shape {
    private double r;
    public Circle(double r) {this.r = r;}
    @Override
    public double area() {return Math.PI*r*r;}
}
public class AbstractPractice {
    public static void main(String[] args) {
        Shape s = new Circle(2);
        s.printArea();
    }
}
