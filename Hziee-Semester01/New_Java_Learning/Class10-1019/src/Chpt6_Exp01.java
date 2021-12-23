public class Chpt6_Exp01 {
    String color = "";
    String place = "";
    public void eatFruit() {
        System.out.println(color + ", " + place);
    }
    public static class Apple extends Chpt6_Exp01 {
        int price;

        public static void main(String[] args) {
            Apple apple001 = new Apple();
            apple001.color = "red";
            apple001.place = "China";
            apple001.price = 100;
            apple001.eatFruit();
        }
    }
}
