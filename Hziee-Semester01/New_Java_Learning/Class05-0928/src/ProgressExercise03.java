public class ProgressExercise03 {
    public static void main(String[] args) {
        double paper = 0.1, sumTarget = 0.0, finalTarget = 8844430;
        int count = 0;
        while (sumTarget <= finalTarget) {
            sumTarget = sumTarget + paper;
            paper = paper * 2;
            count ++;
        }
        System.out.println(count);
    }
}
