package day8;

interface Flyable{
    void fly();
}
class Bird implements Flyable{
    private String name;
    public Bird(String name){
        this.name=name;
    }
    @Override
    public void fly(){
        System.out.println(name+" is flying");
    }
}

public class InterfacePractice {
    public static void main(String[] args) {
        Flyable f = new Bird("Bird");
        f.fly();
    }
}
//为什么写Flyable f = new Bird("小鸟");而不是Bird brid = new Bird("小鸟");