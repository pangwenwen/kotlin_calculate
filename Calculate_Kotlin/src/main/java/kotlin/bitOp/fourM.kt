package kotlin.bitOp
fun isPowerOfFour(n: Int): Boolean {
    return (n>0) and (n and (n-1) == 0) and (n and (0xaaaaaaaa.toInt()) == 0)
}

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums){
        res = res xor i
    }
    return res
}