public class TestOverload01 {
    String ID;
    int years;
    int salary;
    String skill;

    public void setSkill(String a) {
        skill = a;
    }
    public void setSkill(String a, String b) {
        skill = a + ", " + b;
    }
    public void setSkill(String a, String b, String c) {
        skill = a + ", " + b + ", " + c;
    }

    public void peopleWork() {
        System.out.println("ID " + ID + " is working...");
    }

    public static void main(String[] args) {
        TestOverload01 farmer001 = new TestOverload01();
        farmer001.ID = "0xf001";
        farmer001.setSkill("Apple");
        farmer001.setSkill("Apple", "Orange");
        farmer001.setSkill("Apple", "Orange", "Pear");
        farmer001.peopleWork();
    }
}
