public class ExecStack {
    BasicStack specificStack = new BasicStack(100000000);

    public void changeNum(int num) {
        // 判断输入的数是否为0，为0则直接输出0
        if (num == 0) {
            System.out.println(0);
        } else {
            // 计算转换为八进制后的结果，并完成入栈
            while (num != 0) {
                specificStack.inStack(num % 8);
                num = num / 8;
            }
            while (!specificStack.isEmpty()) {
                System.out.print(specificStack.outStack());
            }
        }
    }
}