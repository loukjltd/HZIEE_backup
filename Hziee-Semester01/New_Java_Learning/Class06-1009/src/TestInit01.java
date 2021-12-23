public class TestInit01 {
    String ID;
    int years;
    int salary;
    String skill;

    public TestInit01(String a, int b, int c, String d) {
        ID = a;
        years = b;
        salary = c;
        skill = d;
    }

    public void peopleWork() {
        System.out.println("ID " + ID + " is working...");
    }

    public static void main(String[] args) {
        TestInit01 farmer001 = new TestInit01("0xf001", 5, 5000, "Plant Apple");
        farmer001.peopleWork();
    }
}
