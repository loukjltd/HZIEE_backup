import java.util.Scanner;

public class Class1011Exercise01 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        boolean flag = true;
        boolean isNum = true;
        while (flag) {
            int targetNum = getNum.nextInt();
            if (targetNum == 0) {
                flag = false;
            } else {
                String str = String.valueOf(targetNum);
                char[] chars = str.toCharArray();
                int len = chars.length;
                for (int i = 0; i < len; i++) {
                    if (chars[i] != chars[len - i - 1]) {
                        isNum = false;
                    } else {
                        isNum = true;
                    }

                }
                if (isNum) {
                    System.out.println(targetNum + "是回文数");
                } else {
                    System.out.println(targetNum + "不是回文数");
                }
            }
        }

    }
}
