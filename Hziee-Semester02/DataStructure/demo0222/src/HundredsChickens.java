public class HundredsChickens {
    public static void main(String[] args) {
        int k;
        for (int i = 1; i < 100; i ++) {
            for (int j = 1; j < 100; j ++) {
                k = 100 - i - j;
                if (i + j + k == 100 && 5 * i + 3 * j + k / 3 == 100) {
                    if (k % 3 == 0) {
                        System.out.println("公鸡：" + i);
                        System.out.println("母鸡：" + j);
                        System.out.println("小鸡：" + k);
                        System.out.println();
                    }
                }
            }
        }
    }
}
