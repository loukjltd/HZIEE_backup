import java.util.Scanner;

public class Exercise03_10 {
    public static void main(String[] args) {
        boolean flag = false;
        int i, j, k;
        int targetNum = 0;
        while (!flag) {
            Scanner getNum = new Scanner(System.in);
            targetNum = getNum.nextInt();
            if (targetNum % 2 == 1){
                flag = true;
            }
        }
        for (i = 1; i <= (targetNum + 1) / 2; i ++) {
            for (j = i; j <= (targetNum - 1) / 2; j ++) {
                System.out.print(" ");
            }
            for (k = 1; k <= i * 2 - 1; k ++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (i = (targetNum - 1) / 2; i >= 1; i --) {
            for (j = i; j <= (targetNum - 1) / 2; j ++) {
                System.out.print(" ");
            }
            for (k = i * 2 - 1; k >= 1; k --) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
