import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;
import static sun.misc.Version.print;

public class WeeklyTest_Java {

    public void rotate(int[][] matrix) {
        if (matrix.length == 1) return;
        int size = matrix.length;
        int i = 0;
        while (i < size/2){
            for (int j = i;j<size-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size-j-1][i];
                matrix[size-j-1][i] = matrix[size-i-1][size-j-1];
                matrix[size-i-1][size-j-1] = matrix[j][size-i-1];
                matrix[j][size-i-1] = temp;
            }
            i++;
        }
    }


    public static void main(String[] args) {
//        int[][] tee = {{1,2,3},{4,5,6},{7,8,9}};
//        rotate2(tee);
        "".toCharArray();

        Map[] states = {
                new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 6); put(' ', 9); }}, // 2.
                new HashMap<Character,Integer>() {{ put('d', 5); put('e', 6); put(' ', 9); }},              // 3.
                new HashMap<Character,Integer>() {{ put('d', 5); }},                                        // 4.
                new HashMap<Character,Integer>() {{ put('d', 5); put('e', 6); put(' ', 9); }},              // 5.
                new HashMap<Character,Integer>() {{ put('d', 8); put('s', 7); }},                           // 6.
                new HashMap<Character,Integer>() {{ put('d', 8); }},                                        // 7.
                new HashMap<Character,Integer>() {{ put('d', 8); put(' ', 9); }},                           // 8.
                new HashMap<Character,Integer>() {{ put(' ', 9); }}                                         // 9.
        };

    }
    public static void rotate2(int[][] matrix) {
        if (matrix.length == 1) return;
        int size = matrix.length;
        int i = 0;
        // y=0 进行翻转
        while (i < size / 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[size - 1 - i];
            matrix[size - 1 - i] = temp;
            i++;
        }

        // y = -x 进行翻转
        for (int start = 0; start < size; start++) {
            for (int col = start; col < size; col++) {
                int temp = matrix[start][col];
                matrix[start][col] = matrix[col][start];
                matrix[col][start] = temp;
            }


        }
    }




}
