import java.util.Scanner;

/**
 * @author loukj
 */
public class printN {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int targetNum = getNum.nextInt();
        printN(targetNum);

    }
    public static void printN(int n){
        for (int i = 1; i <= n; i ++) {
            System.out.println(i);
        }
    }
}

