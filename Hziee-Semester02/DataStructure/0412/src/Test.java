import java.util.Date;
import java.util.Scanner;

public class Test {
    // Calculate days between two dates
    public static int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first date in yyyy/mm/dd format: ");
        String date1 = sc.nextLine();
        System.out.println("Enter the second date in yyyy/mm/dd format: ");
        String date2 = sc.nextLine();
        Date d1 = new Date(date1);
        Date d2 = new Date(date2);
        int days = daysBetween(d1, d2);
        System.out.println("The difference between the two dates is " + days + " days.");
    }
}
