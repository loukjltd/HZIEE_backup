/**
 * @author loukj
 */
public class OneYuanCoin3 {
    public static void main(String[] args) {
        int x, y, z;
        for (x = 0; x <= 50; x++) {
            for (y = 0; y <= 50; y++) {
                z = 50 - x - y;
                if (z >= 0) {
                    if (x + 2 * y + 5 * z == 100) {
                        System.out.println("一分:" +
                                x + " " + "两分:" +
                                y + " " + "五分:" + z);
                    }
                }
            }
        }
    }
}
