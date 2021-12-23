public class TestThis01 {
    String ID;
    int years;
    int salary;
    String skill;

    public TestThis01() {
        this("0xf001", 1, 3000, "Apple");
    }

    public TestThis01(String a, int b, int c, String d) {
        ID = a;
        years = b;
        salary = c;
        skill = d;
    }

    public void peopleWork() {
        System.out.println("ID " + ID + " is working...");
    }

    public static void main(String[] args) {
        TestThis01 farmer001 = new TestThis01();
        farmer001.peopleWork();
    }
}
