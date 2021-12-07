import java.util.Scanner;

abstract class Animal_4{
    private String name;
    public Animal_4(String name){this.name=name;}
    public abstract void Sound();
    public String getName(){return name;}
}
class Dog extends Animal_4{
    public Dog(String name){super(name);}
    public void Sound(){
        System.out.println(super.getName()+" is barking");
    }
}

public class Exercise06_04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Dog aDog=new Dog(s);
        aDog.Sound();
        sc.close();
    }
}
