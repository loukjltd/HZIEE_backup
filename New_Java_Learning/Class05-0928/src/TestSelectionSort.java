public class TestSelectionSort {
    public static void main(String[] args) {
        int[] randomNumList = new int[10];
        int minIndex;
        for (int i = 0; i <= randomNumList.length - 1; i ++) {
            randomNumList[i] = (int) (Math.random() * 100);
            System.out.printf("&d ", randomNumList[i]);
        }
        System.out.println();
        for (int i = 0; i < randomNumList.length - 1; i ++) {
            minIndex = i;
            for (int j = i + 1; j < randomNumList.length; j ++) {
                if (randomNumList[i] < randomNumList[minIndex]) {
                    minIndex = j;
                }
                if (minIndex != i) {
                    int tempNum = randomNumList[i];
                    randomNumList[i] = randomNumList[minIndex];
                    randomNumList[minIndex] = tempNum;
                }
            }
            System.out.println("The data after using order: ");
            for (int x: randomNumList) {
                System.out.printf("%d", x);
            }
        }
    }
}
