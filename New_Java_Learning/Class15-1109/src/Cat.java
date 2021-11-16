public class Cat {
    int age;
    int weight;
    String nickName;
    String category;

    public void canRun() {
        System.out.print(nickName + "不仅会跑，");
    }

    public void canEatFish() {
        System.out.print(nickName + "还会吃鱼。");
    }

    public static void main(String[] args) {
        Cat c001 = new Cat();
        c001.age = 3;
        c001.weight = 10;
        c001.nickName = "小王";
        c001.category = "加菲猫";

        c001.canRun();
        c001.canEatFish();
    }
}
