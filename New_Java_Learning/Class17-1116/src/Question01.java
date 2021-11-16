import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        System.out.println("请输入一个不小于7位的整数：");
        long a = getNum.nextLong();
        String numString = Long.toString(a);
        char[] numChar = numString.toCharArray();
        if (numChar.length < 7) {
            System.out.println("您的输入不符合要求。");
        } else {
            System.out.println(a + "从右边开始的4-7位是：" +
                    numChar[numChar.length - 7] +
                    numChar[numChar.length - 6] +
                    numChar[numChar.length - 5] +
                    numChar[numChar.length - 4]);
        }
    }
}
