import java.util.Scanner;

interface CanSwim {void swim();}
interface CanFly {void fly();}
abstract class Animal_05{
    private String name;
    public Animal_05(String name){this.name=name;}
    public abstract void Sound();
    public String getName(){return name;}
}
class Duck extends Animal_05{
    public Duck(String name){super(name);}
    public void Sound(){
        System.out.println(getName()+" is barking");
    }
    public void fly(){
        System.out.println(getName()+" is flying");
    }
    public void swim(){
        System.out.println(getName()+" is swimming");
    }
}

public class Exercise06_05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Duck aDuck=new Duck(s);
        aDuck.Sound();
        aDuck.fly();
        aDuck.swim();
        sc.close();
    }
}
