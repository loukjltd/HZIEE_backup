import java.util.Scanner;

public class TestSequentialSearch {
    public static void main(String[] args) {
        Scanner getScore = new Scanner(System.in);
        int[] scoreList = {78, 81, 67, 90, 76, 89, 45, 78, 57, 71};
        int testNum;
        int indexLocation = -1;
        testNum = getScore.nextInt();
        for (int i = 0; i < scoreList.length; i ++) {
            if (testNum == scoreList[i]) {
                indexLocation = i;
                break;
            }
        }

        if (indexLocation != -1) {
            System.out.printf("已找到！下标为%d", indexLocation);
        } else {
            System.out.println("没找到！");
        }
    }
}
