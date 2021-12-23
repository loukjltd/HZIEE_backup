import java.util.Scanner;

public class Exercise04_02 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[] a = {9, 13, 25, 34, 38, 62, 69, 78, 86, 97};
        int searchNum = kb.nextInt();
        int index, left, mid, right;
        index = -1;
        left = 0;
        right = a.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] == searchNum) {
                index = mid;
                break;
            }
            else if (a[mid] < searchNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            System.out.println("在数组中不存在！");
        } else {
            System.out.println("在数组中位置是" + index);
        }
    }
}
