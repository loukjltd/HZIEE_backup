import java.util.Scanner;

public class ExerciseFishTime {
    public static void main(String[] args) {
        Scanner inputStartHour = new Scanner(System.in);
        Scanner inputStartMin = new Scanner(System.in);
        Scanner inputEndHour = new Scanner(System.in);
        Scanner inputEndMin = new Scanner(System.in);
        int startHour, startMin, endHour, endMin, finalHour, finalMin;
        startHour = inputStartHour.nextInt();
        startMin = inputStartMin.nextInt();
        endHour = inputEndHour.nextInt();
        endMin = inputEndMin.nextInt();
        finalHour = endHour - startHour;
        finalMin = endMin - startMin;
        System.out.println(finalHour + "小时" + finalMin + "分钟");

    }
}
