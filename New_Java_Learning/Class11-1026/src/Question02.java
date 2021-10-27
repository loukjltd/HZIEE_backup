import sun.security.util.Length;

public class Question02 {
    public static void main(String[] args) {
        char[] charArrayA;
        charArrayA = new char[10];
        charArrayA[0] = 48;
        for (int i = 1; i < charArrayA.length; i ++) {
            charArrayA[i] = (char) (charArrayA[i - 1] + 1);
            System.out.print((charArrayA[i - 1] + " "));
            if (i == charArrayA.length - 1) {
                System.out.println(charArrayA[i]);
            }
        }
        System.out.println();


        int[] intArrayB;
        intArrayB = new int[26];
        intArrayB[0] = 97;
        int countB = 0;
        for (int j = 1; j < intArrayB.length; j ++) {
            intArrayB[j] = intArrayB[j - 1] + 1;
            System.out.print((char)intArrayB[j - 1] + " ");
            if (j == intArrayB.length - 1) {
                System.out.println((char)intArrayB[j]);
            }
            countB ++;
            if (countB % 10 == 0) {
                System.out.println();
            }
        }
    }

}
