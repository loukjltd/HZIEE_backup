import java.util.Scanner;

public class AcmExercise06 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        while(getNum.hasNext()) {
            int num = getNum.nextInt();
            int totalNum = 0;
            for(int i = 0; i < num; i ++){
                int x = getNum.nextInt();
                totalNum += x;
            }
            System.out.println(totalNum);
        }
    }
}
