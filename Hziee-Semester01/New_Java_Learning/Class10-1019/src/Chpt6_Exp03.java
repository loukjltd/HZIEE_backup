public class Chpt6_Exp03 {
    public void isHealth() {
        System.out.println("Eating fruit is good for health.");
    }
    public static class Apple extends Chpt6_Exp03 {
        public void isHealth(String getContent) {
            System.out.println("Common：" + getContent);
        }
        public void isHealth(String patient, String content) {
            System.out.println("For " + patient + ", " + content);
        }

        public static void main(String[] args) {
            Apple apple003 = new Apple();
            apple003.isHealth();
            apple003.isHealth("quench thirst, moisten lung in addition to trouble, spleen and stomach");
            apple003.isHealth("Obesity and diabetes", "Apples are more beneficial to eat than oranges and pears");
        }
    }
}
