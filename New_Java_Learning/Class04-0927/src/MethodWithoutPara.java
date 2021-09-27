public class MethodWithoutPara {
    public static void main(String[] args) {
        System.out.print("18 != ");
        fact();
        System.out.println("Bye.");
    }

    static void fact() {
        double randomNum = 1;
        for (int i = 1; i <= 18; i ++) {
            randomNum = randomNum * i;
        }
        System.out.printf("%.0f\n", randomNum);
    }
}
