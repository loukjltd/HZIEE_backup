import java.util.Scanner;

public class AcmExercise05 {
    public static void main(String[] args) {
        Scanner howManyNums = new Scanner(System.in);
        int num1, num2, totalNum;
        int n = howManyNums.nextInt();
        int i = 0;
        for(i = 0; i < n; i ++){
            while (howManyNums.hasNext()) {
                totalNum = 0;
                num1 = howManyNums.nextInt();
                if (num1 == 0)break;
                while (num1 > 0){
                    num2 = howManyNums.nextInt();
                    totalNum += num2;
                    num1 --;
                }
                System.out.println(totalNum);
            }

//        Scanner howManyArrayNums = new Scanner(System.in);
//        int totalTimes = howManyArrayNums.nextInt();
//        Scanner getNum = new Scanner(System.in);
//        int countNums = 1;
//        while (countNums <= totalTimes) {
//            String numString = getNum.nextLine();
//            String[] numArray = numString.split(" ");
//            int totalNum = 0;
//            for (int i = 1; i < numArray.length; i++) {
//                totalNum += Integer.parseInt(numArray[i]);
//            }
//            System.out.println(totalNum);
//            countNums += 1;
        }
    }
}
