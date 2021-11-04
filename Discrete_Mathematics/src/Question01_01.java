public class Question01_01 {
    public static void main(String[] args) {
        int result;
        int r1, r2;
        int count = 0;
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┣ " + " p " + " ╋ " + " q " + " ╋ " + " r " + " ╋ " + " s " + " ╋ " + " A " + " ┫");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        for (int p = 0; p <= 1; p++) {
            for (int q = 0; q <= 1; q++) {
                for (int r = 0; r <= 1; r++) {
                    for (int s = 0; s <= 1; s++) {
                        if (p == 1 || q == 1) {
                            r1 = 0;
                        } else {
                            r1 = 1;
                        }
                        if ((p == 1 || r == 1) || s == 1) {
                            r2 = 1;
                        } else {
                            r2 = 0;
                        }
                        if (r1 == 1 && r2 == 1) {
                            result = 1;
                        } else {
                            result = 0;
                        }
                        count ++;
                        System.out.println("┣  " + p + "  ╋  " + q + "  ╋  " + r + "  ╋  " + s + "  ╋  " + result + "  ┫");
                        if (count != 16) {
                            System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
                        }
                    }
                }
            }
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
