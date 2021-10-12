import java.util.Scanner;

public class UsePassword {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String psw;
        String s = "~!@#$%^";
        int i, len, k1, k2, k3;
        char ch;
        k1 = k2 = k3 = 0;
        psw = kb.nextLine();
        len = psw.length();
        for (i = 0; i < len; i ++) {
            ch = psw.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                k1 = 1;
            } else {
                if (ch >= '0' && ch <= '9') {
                    k2 = 1;
                } else {
                    if (len >= 8) {
                        k3 = 1;
                    }
                }
            }
        }
        if (k1 == 1 && k2 == 1 && k3 == 1) System.out.println("Yes!");
        else System.out.println("No!");
    }
}
