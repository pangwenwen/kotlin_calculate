package Matrix;

// https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
public class RobotRemove {

    public static void main(String[] args) {
        int[][] arr = new int[7][2];
        movingCount(1,2,1);
    }

    static int row;
    static int col;
    static boolean[][] visisted;
    public  static int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        row = m;
        col = n;
        visisted = new boolean[row][col];
        return move(0,0,k);
    }

    private static int move(int x,int y,int target){
        if (x>row-1 || y>col-1 || visisted[x][y]) return 0;
        int sum = getSum(x,y);
        if (sum > target) return 0;
        visisted[x][y] = true;
        return 1+move(x+1,y,target)+move(x,y+1,target);
    }

    private static int getSum(int x,int y){
        int sum = 0;
        while (x >0){
            sum+=x%10;
            x = x/10;
        }

        while (y >0){
            sum+=y%10;
            y = y/10;
        }
        return sum;
    }
}
