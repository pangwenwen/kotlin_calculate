package Matrix;

public class findeString_offer12 {

    public static void main(String[] args) {
        char[][] a= {{'b','a'}};
        exist(a,"ab");

    }


    static int[][] ergodicMark; // 用于记录遍历过的点 0:没有遍历；1 已经遍历
    static int index = 0;
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || board.length *board[0].length<word.length()){
            return false;
        }
        int line = board.length;
        int col = board[0].length;
        ergodicMark = new int[line][col];
        char[] strArray = word.toCharArray();
        for (int i = 0;i<line;i++){
            for (int j = 0;j<col;j++){
                if (find(board,i,j,strArray))
                    return true;

            }
        }
        return false;

    }

    static boolean find(char[][] board,int x,int y,char[] strA){
        if (x < 0 || x>board.length-1 || y<0 || y>board[0].length-1 || index <0 || index>=strA.length)
            return false;
        if (ergodicMark[x][y] == 1)
            return false;

        char matrixC = board[x][y];
        char strAC = strA[index];
        if (matrixC != strAC)
            return false;

        if (index == strA.length-1)
            return true;

        // 相等则遍历其上下左右
        ergodicMark[x][y] = 1;
        index++;

        if (find(board,x-1,y,strA))
            return true;
        if (find(board,x+1,y,strA))
            return true;
        if (find(board,x,y-1,strA))
            return true;
        if (find(board,x,y+1,strA))
            return true;

        ergodicMark[x][y] = 0;
        index--;
        return false;
    }






    //////////////////////////////////////////////
    //leetcode 解题法
    public boolean exist2(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
