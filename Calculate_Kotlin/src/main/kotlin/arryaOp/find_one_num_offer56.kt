package arryaOp

//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/

fun main() {
    println(1 ushr  1)
    val array = intArrayOf(3,4,3,3)
    println(singleNumber(array))
}

fun singleNumber(nums: IntArray): Int {
    var count = IntArray(32)
    for (num in nums){
        var temp = num
        for (index in count.indices){
            count[index] += temp and 1
            temp = temp ushr 1
        }
    }

    val fre = 3
    var res = 0
    for (index in count.indices){
        res = res shl 1 // 为什么先左移
        res = res or count[31-index] % fre
    }
    return res
}