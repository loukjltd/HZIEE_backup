import java.util.Scanner;

public class Rectangle2 {

    public void Test() {
        Scanner getWidth = new Scanner(System.in);
        Scanner getHeight = new Scanner(System.in);

        int newWidth = getWidth.nextInt();
        int newHeight = getHeight.nextInt();

        System.out.println();
        System.out.print("草皮的价格为：" + (newWidth * newHeight) * 120 + "元");
    }


    public static void main(String[] args) {
        Rectangle2 r001 = new Rectangle2();
        r001.Test();
    }
}
