public class TestStaticMethod {
    public static int registerMoney = 1000000;
    public static String getContent = "Fruit & planting";
    public static String getDate = "2000/1/1";
    public static String headMan = "Lee";
    public static String getAddress = "West Lake Area, Hangzhou";
    public static String getName = "Fruit Garden";

    public static void welcomeToGarden() {
        System.out.println("Welcome");
    }

    public int getSalary(int memberType) {
        int targetMoney;
        switch (memberType) {
            case 1:
                targetMoney = 6000;
                break;
            case 2:
                targetMoney = 4000;
                break;
            default:
                targetMoney = 3000;
        }
        return targetMoney;
    }

    public static void main(String[] args) {
        TestStaticMethod.welcomeToGarden();
        TestStaticMethod member001 = new TestStaticMethod();
        System.out.println("Your target salary is " + member001.getSalary(1));
        TestStaticMethod.welcomeToGarden();
        System.out.println("Again");
    }
}