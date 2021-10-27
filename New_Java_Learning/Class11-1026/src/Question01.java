public class Question01 {
    public static void main(String[] args) {
        int[] getArray;
        getArray = new int[5];
        for (int i = 0; i < getArray.length; i ++) {
            getArray[i] = i * i;
            System.out.println("数组引用：" + i + "；数组长度：" + getArray.length);
            System.out.println("数组元素的值：" + getArray[i]);
            System.out.println();
        }
        System.out.println();
    }
}
