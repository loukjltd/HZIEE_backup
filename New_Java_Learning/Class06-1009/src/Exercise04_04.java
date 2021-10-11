import java.util.Scanner;

public class Exercise04_04 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int targetNum = getNum.nextInt();
        String finalNum = Integer.toBinaryString(targetNum);
        System.out.println(finalNum);
    }
}
