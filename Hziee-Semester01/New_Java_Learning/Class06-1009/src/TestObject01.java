public class TestObject01 {
    String ID;
    int years;
    int salary;
    String skill;
    public void peopleWork() {
        System.out.println("ID " + ID + " is working...");
    }

    public static void main(String[] args) {
        TestClass01 farmer001 = new TestClass01();
        farmer001.ID = "0xf001";
        farmer001.salary = 5000;
        farmer001.peopleWork();
    }
}
