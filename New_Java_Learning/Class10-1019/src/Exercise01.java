import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner getDate = new Scanner(System.in);
        int targetYear = getDate.nextInt();
        int targetMonth = getDate.nextInt();
        int specialDay1 = 28;
        int specialDay2 = 29;
        int smallMonth = 30;
        int bigMonth = 31;
        switch (targetMonth) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println(bigMonth);
                break;
            case 2:
                if (targetYear % 4 == 0) {
                    System.out.println(specialDay2);
                } else {
                    System.out.println(specialDay1);
                }
                break;
            case 4: case 6: case 9: case 11:
                System.out.println(smallMonth);
                break;
            default:
                System.out.println();
        }
    }
}
