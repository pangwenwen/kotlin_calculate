package arryaOp
import kotlin.math.max

//https://leetcode-cn.com/problems/container-with-most-water/

fun main() {
    val arrya = intArrayOf(1,8,6,2,5,4,8,3,7)
    maxArea(arrya)
}

fun maxArea(height: IntArray): Int {
    if (height == null || height.size < 2) return -1
    var maxA = 0
    var start = 0
    var end = height.size-1

    while (start < end){
        val i = height[start]
        val j = height[end]

        val temp = (end-start)* j.coerceAtMost(i)
        maxA = max(maxA,temp)

        // 谁小移动谁
        if (i > j) end--
        else start++
    }

    return maxA
}
