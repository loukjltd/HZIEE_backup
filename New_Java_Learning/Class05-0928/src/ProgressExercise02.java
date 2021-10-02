public class ProgressExercise02 {
    public static void main(String[] args) {
        int finaScore = (int) (Math.random() * 40 + 61);
        String gift1 = "家里一日游";
        String gift2 = "MacBook Pro";
        String gift3 = "iPhone Pro Max";
        String gift4 = "双打体验劵";

        System.out.print((finaScore >= 95 && finaScore <= 100) ? gift1 : "");
        System.out.print((finaScore >= 90 && finaScore < 95) ? gift2 : "");
        System.out.print((finaScore >= 80 && finaScore < 90) ? gift3 : "");
        System.out.print((finaScore < 80) ? gift4 : "");
    }
}
