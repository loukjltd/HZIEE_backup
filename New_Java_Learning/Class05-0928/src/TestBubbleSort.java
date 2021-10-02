import java.util.Random;

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] numList = new int[10];
        boolean flag = false;
        Random ran = new Random();
        for (int i = 0; i <= numList.length - 1; i ++) {
            numList[i] = ran.nextInt(90) + 10;
            System.out.println(numList[i] + "");
        }
        System.out.println();
        for (int j = 1; j < numList.length; j ++) {
            for (int i = 0; i < numList.length - j; i ++) {
                if (numList[i] > numList[i + 1]) {
                    int tempNum = numList[i];
                    numList[i] = numList[i + 1];
                    numList[i + 1] = tempNum;
                }
            }
        }
        System.out.println("Final order: ");
        for (int x: numList) {
            System.out.println(x + " ");
        }
    }
}
