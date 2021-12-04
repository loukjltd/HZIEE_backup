
class Fruit6_2{
    String color="";
    String place="";
    public void eat(){
        System.out.println(color + ", "+ place);
    }
}

public class Example06_02 extends Fruit6_2{
    int price;
    public void eat(){
        System.out.println(color+","+place);
        System.out.println(price);
    }
    public static void main(String[] args) {
        Example06_02 testFruit = new Example06_02();
        testFruit.color = "酒红";
        testFruit.place = "日本";
        testFruit.price = 100;
        testFruit.eat();

    }
}