package bitOp

//只适合正数个位数加法
fun getSum(a: Int, b: Int): Int {
    return ((a and b) shl  1) or (a xor b)
}

fun getSum2(a: Int, b: Int): Int {
    var AND = a and b
    var XOR = (a xor b) shl 1
    while (AND != 0){
        val temp = AND and XOR
        XOR = XOR xor AND
        AND = temp shl 1
    }
    return XOR
}