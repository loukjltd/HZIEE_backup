import java.util.Scanner;

public class Chapter05_06 {
    public static void main(String[] args) {
        People p01 = new People();
        p01.name = "Sam";
        p01.height = 180;
        p01.weight = 80;
        if (p01.check() == 1) {
            System.out.println("过胖");
        } else if (p01.check() == -1) {
            System.out.println("过瘦");
        } else {
            System.out.println("标准");
        }

    }
}

class People {
    String name;
    int height;
    int weight;

    public People() {

    }

    public int check() {
        int standardWeight;
        standardWeight = height - 110;
        if (weight - standardWeight > 5) {
            return 1;
        } else if (weight - standardWeight < -5) {
            return -1;
        } else {
            return 0;
        }
    }
}
