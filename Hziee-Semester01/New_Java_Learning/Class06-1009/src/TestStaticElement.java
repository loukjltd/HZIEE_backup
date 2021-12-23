public class TestStaticElement {
    public static int registerMoney = 1000000;
    public static String getContent = "Fruit & planting";
    public static String getDate = "2000/1/1";
    public static String headMan = "Lee";
    public static String getAddress = "West Lake Area, Hangzhou";
    public static String getName = "Fruit Garden";

    public static void main(String[] args) {
        System.out.println("The CEO of this farmer is " + TestStaticElement.headMan);
        System.out.println("The address is located in " + TestStaticElement.getAddress);
    }
}
