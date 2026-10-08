package day06;
class Animal{
    protected String name;
    public Animal(String name){this.name=name;}
    public void eat(){System.out.println(name+" is eating");}
}
class Dog extends Animal{
    public Dog(String name){super(name);}
    @Override
    public void eat(){System.out.println(name+" 在啃骨头");}
    public void bark(){System.out.println(name+"汪汪叫");}
}
class Cat extends Animal{
    public Cat(String name){super(name);}
    @Override
    public void eat(){
        System.out.println(name + "在吃鱼");
    }
}
public class InheritancePractice {
    public static void main(String[] args) {
        Animal a1 = new Dog("旺财");
        Animal a2 = new Cat("咪咪");
        a1.eat();
        a2.eat();
        Dog d = (Dog)a1;
        d.bark();
    }

}
