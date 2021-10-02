import java.util.Scanner;

public class Exercise03_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k, count = 0; //填空1
        int a = sc.nextInt();
        if (a < 0) a = -a;
        while (a != 0) { //填空2
            k = a % 10;
            a = a / 10; //填空3
            if (k == 7) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
