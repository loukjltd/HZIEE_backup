import java.util.Scanner;

public class TestIDCard {
    public static void main(String[] args) {
        String hangzhouCode = "3301";
        System.out.println("Please enter your ID Number: ");
        Scanner getNum = new Scanner(System.in);
        String targetID = getNum.nextLine();
        if (targetID.length() != 18) {
            System.out.println("Wrong ID Number!");
        }

        String idYear = targetID.substring(6, 10);
        String idMonth = targetID.substring(10, 12);
        String idDay = targetID.substring(12, 14);
        int sexNum = targetID.charAt(16) - '0';

        System.out.println("Birthday: " + idYear + '-' + idMonth + '-' + idDay);

        if (sexNum == 0) {
            System.out.println("Gender: Madam");
        } else if (sexNum == 1) {
            System.out.println("Gender: Male");
        } else {
            System.out.println("Gender: ...Are you a mankind?");
        }

        String idLocation = targetID.substring(0, 4);
        if (hangzhouCode.equals(idLocation)) {
            System.out.println("You Are in Hangzhou.");
        } else {
            System.out.println("You Are Not in Hangzhou.");
        }
    }
}
