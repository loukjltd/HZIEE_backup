public class MethodWithoutPara {
    public static void main(String[] args) {
        System.out.print("18 != ");
        customFact();
        System.out.println("Bye~\n");
    }

    static void customFact() {
        double num = 1;
        for (int i = 1; i <= 18; i ++) {
            num = num * i;
        }
        System.out.printf("%.0f", num);
    }
}
