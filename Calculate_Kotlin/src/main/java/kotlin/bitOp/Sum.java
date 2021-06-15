package bitOp;

public class Sum {
    int getSum(int a, int b){
        int AND = (a & b) << 1;
        int XOR = a ^ b;
        while (AND != 0){
            int temp = AND & XOR;
            XOR = XOR ^ AND;
            AND = temp << 1;
        }
        return XOR;
    }


    public int getSum2(int a, int b) {
        int XOR = (a ^ b) << 1;  //无进位加法
        int AND = a & b;  //进位运算
        while (AND != 0) {
            int temp = XOR & AND;
            XOR = XOR ^ AND;
            AND = temp << 1;
        }
        return XOR;
    }

}
