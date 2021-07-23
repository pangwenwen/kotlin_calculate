package kotlin.dp

fun rob(nums: IntArray): Int {
    if(nums.size == 1) return nums[0]
    if (nums.size == 2){
        return if (nums[0]> nums[1]) nums[0]
        else nums[1]
    }

    val size = nums.size
    var dp = IntArray(size)
    dp[0] = nums[0]
    dp[1] = nums[1]
    dp[2] = nums[0]+nums[2]

    for (i in 3 until size){
        dp[i] = nums[i] + Math.max(dp[i-2],dp[i-3])
    }

    return if (dp[size-2]> dp[size-1]) dp[size-2]
    else dp[size-1]

}