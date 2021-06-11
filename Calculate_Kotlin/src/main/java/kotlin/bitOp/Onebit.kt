package bitOp

// https://leetcode-cn.com/problems/number-of-1-bits/


fun main() {
    print(hammingWeight2(3))
}
// 1. 使用 & 去掉最右边的1
fun hammingWeight(n:Int):Int {
    if (n == 0) return 0
    var count = 0
    var t = n
    while ((t and (t-1)) != 0){
        count++
        t = t and (t-1)
    }
    return count+1
}

// 2. 使用右移
fun hammingWeight2(n:Int):Int {
    var count = 0
    var t = n
    while (t != 0){
        if (t and 1 == 1){
            count++
        }
        t = t ushr 1
    }
    return count
}