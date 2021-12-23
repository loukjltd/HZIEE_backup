import java.util.Arrays;

public class Question05 {
    public static void main(String[] args) {
        HighAndLow("1 2 -3 4 5");
        System.out.println(HighAndLow("1 2 -3 4 5"));
    }

    public static String HighAndLow(String numbers) {
        String [] getString = numbers.split(" ");
        int [] stringArray = new int[getString.length];
        for (int i = 0;i < getString.length; i ++){
            int num = Integer.parseInt(getString[i]);
            stringArray[i] = num;
        }
        Arrays.sort(stringArray);
        return (stringArray[stringArray.length-1]+" "+stringArray[0]);
    }
}
