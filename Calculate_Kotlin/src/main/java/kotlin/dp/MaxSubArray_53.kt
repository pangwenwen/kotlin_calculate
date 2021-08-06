package dp

// https://leetcode-cn.com/problems/maximum-subarray/
fun maxSubArray(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var max = nums[0]
    var dp = nums[0]
    for (i in 1 until nums.size){
        dp = Math.max(nums[i],dp+nums[i])
        max = Math.max(dp,max)
    }
    return max
}