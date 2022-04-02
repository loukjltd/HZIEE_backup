public class BasicStack {
    // 建立一个变量用于存储最大的长度
    private final int maxLength;
    // 建立一个数组用于存储栈的数据
    private final int[] stackStorage;
    // 当栈为空时索引的位置为-1，非空时引入栈的索引位置
    private int topIndex = -1;

    // 构造一个栈的方法
    public BasicStack(int maxLength) {
        this.maxLength = maxLength;
        stackStorage = new int[this.maxLength];
    }

    // 返回栈中顶部的值
    int topValue() {
        return stackStorage[topIndex];
    }

    // 判断栈中是否为空
    boolean isEmpty() {
        return topIndex == -1;
    }

    // 判断栈中是否已满
    boolean isFull() {
        return topIndex == maxLength - 1;
    }

    // 入栈方法
    void inStack(int v) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }

        topIndex++;
        stackStorage[topIndex] = v;
    }

    // 出栈方法
    int outStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无数值");
        }

        int v = stackStorage[topIndex];
        topIndex--;
        return v;
    }

    // 判断值是否在栈中
    private boolean isExist(int v) {
        if (isEmpty()) {
            System.out.println("栈为空，无数值");
            return false;
        }

        for (int i = topIndex; i >= 0; i--) {
            if (v == stackStorage[i]){
                return true;
            }
        }
        return false;
    }
}

