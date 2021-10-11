import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        Date oldTime = new Date();
        long oldTargetTime = oldTime.getTime();
        System.out.println("The time before loop: " + oldTime);

        int sum = 0;
        for (int i = 0; i < 1000000000; i ++) {
            sum += i;
        }

        Date newTime = new Date();
        long newTargetTime = newTime.getTime();
        System.out.println("The time after loop: " + newTime);
        System.out.println("Total cost: " + (newTargetTime - oldTargetTime));
    }
}
