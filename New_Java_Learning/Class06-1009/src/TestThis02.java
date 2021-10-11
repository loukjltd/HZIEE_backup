public class TestThis02 {
    String ID;
    int years;
    int salary;
    String skill;

    public TestThis02(String ID, int years, int salary, String skill) {
        this.ID = ID;
        this.years = years;
        this.salary = salary;
        this.skill = skill;
    }

    public void peopleWork() {
        System.out.println("ID " + ID + " is working...");
    }

    public static void main(String[] args) {
        TestThis02 farmer001 = new TestThis02("0xf001", 1, 3000, "Apple");
        farmer001.peopleWork();
    }
}
