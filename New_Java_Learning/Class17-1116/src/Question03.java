import java.util.Scanner;

public class Question03 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入字符串：");
            Scanner getString = new Scanner(System.in);
            String targetString = getString.nextLine();

            if (targetString.equals("end")) {
                System.out.println("结束");
                break;
            }

            int lowerCase = 0;
            int upperCase = 0;
            for (int i = 0; i < targetString.length(); i++) {
                char a = targetString.charAt(i);
                if (a >= 65 && a <= 90) {
                    a = (char) (a + 32);
                    upperCase++;
                } else if (a >= 97 && a <= 122) {
                    a = (char) (a - 32);
                    lowerCase++;
                } else {
                    a = 42;
                }

                System.out.print(a);
            }

            System.out.println();
            System.out.println("总共" + (upperCase + lowerCase) + "个字母");
        }
    }
}
