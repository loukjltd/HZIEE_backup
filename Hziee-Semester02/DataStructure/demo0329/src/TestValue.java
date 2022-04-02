import java.util.Scanner;

public class TestValue {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        System.out.println("请输入十进制数：");
        int targetNum = getNum.nextInt();
        System.out.println("转换的八进制如下：");
        ExecStack execStack = new ExecStack();
        execStack.changeNum(targetNum);
    }
}
