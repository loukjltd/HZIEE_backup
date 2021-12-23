import java.util.Scanner;

public class Exercise03_05 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int count = getNum.nextInt();
        int finalNum;
        int minusNum = 0;
        int zeroNum = 0;
        int plusNum = 0;
        for (int i = 0; i < count; i ++) {
            finalNum = getNum.nextInt();
            if (finalNum == 0) {
                zeroNum += 1;
            }else if (finalNum < 0) {
                minusNum += 1;
            }else{
                plusNum += 1;
            }
        }
        System.out.println("负数：" + minusNum + " " + "零：" + zeroNum + " " + "正数：" + plusNum);
    }
}
