import java.util.Scanner;

public class ExerciseTripleSum {
    public static void main(String[] args) {
        Scanner newNum = new Scanner(System.in);
        int inputNum;
        inputNum = newNum.nextInt();
        float a, b, c;
        a = inputNum % 10;
        b = (inputNum / 10) % 10;
        c = (inputNum / 100) % 10;
        System.out.println(a + b + c);

    }
}
