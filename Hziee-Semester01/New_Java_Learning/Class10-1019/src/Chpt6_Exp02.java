public class Chpt6_Exp02 {
    String color = "";
    String place = "";
    public void eatFruit() {
        System.out.println(color + ", " + place);
    }
    public static class Apple extends Chpt6_Exp02 {
        int price;
        public void eatFruit() {
            System.out.println(color + ", " + place);
            System.out.println(price);
        }

        public static void main(String[] args) {
            Apple apple002 = new Apple();
            apple002.color = "red";
            apple002.place = "Japan";
            apple002.price = 100;
            apple002.eatFruit();
        }
    }
}
