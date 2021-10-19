import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int targetNum = getNum.nextInt();
        switch (targetNum) {
            case 1:
                System.out.println("一");
                break;
            case 2:
                System.out.println("二");
                break;
            case 3:
                System.out.println("三");
                break;
            case 4:
                System.out.println("四");
                break;
            case 5:
                System.out.println("五");
                break;
            case 6:
                System.out.println("六");
                break;
            case 7:
                System.out.println("七");
                break;
            case 8:
                System.out.println("八");
                break;
            case 9:
                System.out.println("九");
                break;
            case 0:
                System.out.println("零");
                break;
            default:
                System.out.println();
        }
    }
}
