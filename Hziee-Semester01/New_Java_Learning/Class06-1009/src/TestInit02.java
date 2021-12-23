public class TestInit02 {
    String ID;
    int years;
    int salary;
    String skill;

    public TestInit02() {
        years = 1;
        salary = 3000;
    }

    public TestInit02(String para1, int para2, int para3, String para4) {
        ID = para1;
        years = para2;
        salary = para3;
        skill = para4;
    }

    public void peopleWork() {
        System.out.println("ID " + ID + " is working...");
    }

    public static void main(String[] args) {
        TestInit02 farmer001 = new TestInit02();
        farmer001.ID = "0xf001";
        farmer001.peopleWork();
    }
}
