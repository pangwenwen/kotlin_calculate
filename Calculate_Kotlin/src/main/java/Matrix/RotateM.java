package Matrix;

public class RotateM {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    }


    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1){
            return;
        }

        int line = matrix.length;
        int opNum = line / 2;

        for (int i = 0;i<opNum;i++){
            // 注意j的起始位置
            for (int j = i;j<line-1-i;j++){
                int tempRT = matrix[i][j];
                int tempLT = matrix[j][line-1-i];
                int tempLB = matrix[line-1-i][line-1-j];
                int tempRB = matrix[line-1-j][i];

                matrix[j][line-1-i] = tempRT;
                matrix[line-1-i][line-1-j] = tempLT;
                matrix[line-1-j][i] = tempLB;
                matrix[i][j] = tempRB;
            }
        }
    }




}
