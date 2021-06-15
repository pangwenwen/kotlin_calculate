package bitOp

fun totalHammingDistance(nums: IntArray): Int {
    var res = 0
    val n = nums.size
    for(num in 0..29){
        var c = 0
        for (i in nums){
            c += (i ushr num) and 1
        }
        res += c * (n-c)

    }
    return res
}