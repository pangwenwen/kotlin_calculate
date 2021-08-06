package dp

//https://leetcode-cn.com/problems/jump-game-ii/

fun main() {
    val array = intArrayOf(2,3,1,1,4)
    jump(array)
}

fun jump(nums: IntArray): Int {
    val size = nums.size
    if (size == 1 ) return 0
    if (nums[0] == 0) return -1

    // dp[i] 代表跳到 i 时所需要的最小步数
    var dp = IntArray(size)
    for (i in 0 until size){
        val value = nums[i]
        val end = Math.min(size-1,i+value)
        for (j in i+1 .. end){

            if (dp[j] == 0 || dp[j] > dp[i]+1) dp[j] = dp[i]+1
        }
    }
    return dp[size-1]
}