public class Class1011Exercise02 {
    public static void main(String[] args) {

        for (int i = 1; i * i < 30; i ++) {
            for (int j = i; j * j < 30; j ++) {
                int s = i * i + j * j;
                if (10 <= s && s <= 30 && s % 2 == 1) {
                    System.out.println(s + "=" + i * i + "+" + j * j);
                }
            }
        }
    }
}
