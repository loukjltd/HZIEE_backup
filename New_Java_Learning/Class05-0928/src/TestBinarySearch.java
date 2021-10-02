import java.util.Scanner;

public class TestBinarySearch {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int[] numList = {9, 13, 25, 34, 38, 62, 69, 78,86, 97};
        int targetNum = getNum.nextInt();
        int indexLocation = -1, left = 0, mid, right;
        right = numList.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (numList[mid] == targetNum) {
                indexLocation = mid;
                break;
            } else if (numList[mid] == targetNum) {
                indexLocation = mid;
                break;
            } else {
                right = mid - 1;
            }
        }
        if (indexLocation == 1) {
            System.out.printf("%d在数组中不存在！", targetNum);
        } else {
            System.out.printf("%d在数组中下标是%d", targetNum, indexLocation);
        }
    }
}
