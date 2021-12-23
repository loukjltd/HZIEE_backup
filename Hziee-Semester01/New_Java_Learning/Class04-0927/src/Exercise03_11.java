import java.util.Scanner;

public class Exercise03_11 {
    static int nDigit(int n, int k) {
        int i, count = 0;
        String strNum;
        strNum = Integer.toString(n);
        for (i = 0; i < String.valueOf(n).length(); i ++) {
            if (strNum.substring(i, i + 1).equals(Integer.toString(k))) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int countNum = getNum.nextInt();
        int targetNum = 0;
        int luckiestNum = 0;
        int numOfEight = 0;
        boolean hasLuckiestNum = false;
        for (int i = 0; i < countNum; i ++) {
            targetNum = getNum.nextInt();
            if (nDigit(targetNum, 8) == 0) {
                hasLuckiestNum = false;
            } else if (nDigit(targetNum, 8) > numOfEight) {
                hasLuckiestNum = true;

            }
        }
        if (hasLuckiestNum) {
            luckiestNum = targetNum;
            System.out.println(luckiestNum);
        } else {
            System.out.println("NO");
        }
    }
}
