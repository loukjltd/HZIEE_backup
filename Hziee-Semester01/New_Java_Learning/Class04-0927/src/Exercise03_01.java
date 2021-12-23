public class Exercise03_01 {
    public static void main(String[] args) {
        double fahr = 0; // 填空1
        double celsius;
        System.out.println("华氏温度   摄氏温度");
        while (fahr >= 0 && fahr <= 80) { //填空2
            celsius = (fahr - 32) * 5 / 9; //填空3
            System.out.printf("%3.0f   %6.1f\n", fahr, celsius);
            fahr = fahr + 20; //填空4
        }
    }
}
