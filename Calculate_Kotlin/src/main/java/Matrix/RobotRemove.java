package Matrix;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
public class RobotRemove {

    public static void main(String[] args) {
        movingCount(5,5,5);
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
        System.out.println("x="+x+" y="+y);
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

    public int movingCount2(int m, int n, int k) {
        if(k == 0) return 1;
        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        int res = 0;

        while (!queue.isEmpty()){
            int[] p = queue.removeFirst();
            int x = p[0],y = p[1];
            if(x>=m || n>=y || visited[x][y] || getSum(x,y)>k) continue;
            visited[x][y] = true;
            queue.add(new int[]{x+1,y});
            queue.add(new int[]{x,y+1});
        }
        return res;
    }




}




