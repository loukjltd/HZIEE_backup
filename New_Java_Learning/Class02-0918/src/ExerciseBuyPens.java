import java.util.Scanner;

public class ExerciseBuyPens {
    public static void main(String[] args) {
        Scanner pocketMoney = new Scanner(System.in);
        int realMoney, paidMoney, discountOne, discountTwo, finalGet;
        int getNum;
        realMoney = pocketMoney.nextInt();
        getNum = realMoney / 5;
        discountOne = getNum / 20;
        discountTwo = (getNum % 20) / 5;
        finalGet = getNum + discountOne + discountTwo;
        System.out.println(finalGet);
    }
}
