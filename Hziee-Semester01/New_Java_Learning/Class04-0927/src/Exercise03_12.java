import java.util.Scanner;

public class Exercise03_12 {
    static boolean isPrimeNum(long getNum) {
        int i;
        for (i = 2; i <= getNum / 2; i ++) {
            if (getNum % i == 0) {
                break;
            }
        }
        return i > getNum / 2;
    }

    public static void main(String[] args) {
        Scanner getTotalNum = new Scanner(System.in);
        long targetTotalNum = getTotalNum.nextLong();
        for (int i = 2; i <= targetTotalNum; i ++) {
            if (isPrimeNum(i)) {
                System.out.println(i);
            }
        }
    }
}
