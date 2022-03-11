/**
 * @author loukj
 */
public class OneYuanCoin4 {
    public static void main(String[] args) {
        int x, y, z;
        for (x = 0; x <= 50; x = x + 3) {
            z = x / 3;
            y = 50 - 4 * z;
            if (x + y + z == 50 && x + 2 * y + 5 * z == 100) {
                System.out.println("一分:" +
                        x + " " + "两分:" +
                        y + " " + "五分:" + z);
            }
        }
    }
}
