import java.util.Scanner;

public class Exercise03_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = (int) (Math.random() * 100);
        while (true) {
            int k = sc.nextInt();
            if (k > t) System.out.println("Too big!");
            else if (k < t) System.out.println("Too small!");
            else {
                System.out.println("Congratulation!");
                break;
            }
        }
    }
}
