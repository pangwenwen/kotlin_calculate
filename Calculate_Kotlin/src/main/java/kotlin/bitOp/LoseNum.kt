package bitOp

fun main() {
    val arr = intArrayOf(0,1,3)
    missingNumber(arr)
}

fun missingNumber(nums: IntArray): Int {
    val len = nums.size
    var res = 0
    for (i in 0 until len){
        res = (res xor i) xor nums[i]
    }
    res = res xor len
    return res
}