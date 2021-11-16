import java.util.Scanner;

public class Question02 {
    public static void main(String[] args){
        Scanner getData = new Scanner(System.in);
        int groupSum1 = 0;
        int groupSum2 = 0;
        int[][] matrixArray = new int[3][3];
        for (int i = 0; i < matrixArray.length; i ++) {
            System.out.println("请输入第" + (i + 1) + "的数据，以回车结束");
            for (int j = 0; j < matrixArray.length; j ++) {
                matrixArray[i][j] = getData.nextInt();
            }
        }

        for (int i = 0; i < matrixArray.length; i ++) {
            for (int j = 0; j < matrixArray.length; j ++) {
                if (i == j) {
                    groupSum1 += matrixArray[i][j];
                }
                if (i == matrixArray.length - i - 1) {
                    groupSum2 += matrixArray[i][j];
                }
            }
        }
        System.out.println("矩阵对角线之和分别是："+ groupSum1 + "和" + groupSum2);
    }
}
