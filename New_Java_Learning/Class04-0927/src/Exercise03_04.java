import java.util.Scanner;

public class Exercise03_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = (int) (Math.random() * 100); //填空1
        while (true) { //填空2
            int k = sc.nextInt();
            if (k > t) System.out.println("太大！");
            else if (k < t) //填空3
                System.out.println("太小！");
            else {
                System.out.println("恭喜！");
                break; //填空4
            }
        }
    }
}
