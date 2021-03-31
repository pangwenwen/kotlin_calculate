package arryaOp

import java.util.*
import kotlin.math.abs


fun main() {
    val array = intArrayOf(-3,-2,-5,3,-4)
    threeSumClosest(array,-1)
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    val len = nums.size
    var result = Math.pow(10.0, 3.0).toInt()
    Arrays.sort(nums)
    for (i in 0 until len - 2) {
        if (i - 1 > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        var temp2 = i + 1
        var temp3 = len - 1
        var subR = nums[i] + nums[temp2] + nums[temp3]
        while (temp3 > temp2) {
            if (subR == target) {
                return target
            }
            if (subR > target) {
                if (abs(subR - target) < abs(result - target)) {
                    result = subR
                }
                subR = nums[i] + nums[temp2] + nums[--temp3]
                continue
            } else {
                if (abs(subR - target) < abs(result - target)) {
                    result = subR
                }
                subR = nums[i] + nums[++temp2] + nums[temp3]
                continue
            }
        }
    }
    return result
}