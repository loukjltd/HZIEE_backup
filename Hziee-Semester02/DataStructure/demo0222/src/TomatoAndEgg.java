import java.util.Scanner;

/**
 * @author loukj
 */
public class TomatoAndEgg {
    public static void main(String[] args) {
        System.out.println("请输入人数：");
        Scanner getScanner = new Scanner(System.in);
        int peopleNum = getScanner.nextInt();
        int tomatoNum = peopleNum;
        double eggTestNum = peopleNum * 1.5;
        double eggNum;
        if ((eggTestNum - 0.5) % 1 == 0) {
            eggNum = eggTestNum + 0.5;
        } else {
            eggNum = eggTestNum;
        }

        int oilContent = peopleNum * 4;
        int saltContent = peopleNum * 2;
        int sugarContent = peopleNum * 2;
        int greenOnionContent = peopleNum * 10;

        System.out.println("您最终需要使用这些材料完成这个菜品：");
        System.out.println("西红柿" + tomatoNum + "个；");
        System.out.println("鸡蛋" + eggNum + "个；");
        System.out.println("食用油" + oilContent + "毫升；");
        System.out.println("盐1.5-" + saltContent + "克;");
        System.out.println("糖0-" + sugarContent + "克;");
        System.out.println("葱花0-" + greenOnionContent + "克;");
    }
}
