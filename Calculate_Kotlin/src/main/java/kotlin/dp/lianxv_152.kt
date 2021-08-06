package dp

import bitOp.singleNumber

//https://leetcode-cn.com/problems/maximum-product-subarray/
fun maxProduct(nums: IntArray): Int {
    if(nums.size ==1 ) return nums[0]
    val len = nums.size
    var dp = Pair(0,0)

    // dp 存储到目前最大的值
    // pair 中first存储+ ，second 存储- , 绝对值最大
    var res = nums[0]
    if (nums[0] >= 0){
        dp = Pair(nums[0],0)
    }else{
        dp = Pair(0,nums[0])
    }

    for (i in 1 until len){

        if (nums[i] == 0)
            dp=Pair(0,0)
        else if (nums[i] > 0){
            val max = Math.max(dp.first*nums[i],nums[i])
            dp = Pair(max,dp.second*nums[i])
        }else{
            val max = Math.max(dp.second * nums[i],0)
            val min = Math.min(nums[i],dp.first*nums[i])
            dp = Pair(max,min)
        }
        res = Math.max(res,dp.first)
        res = Math.max(res,dp.second)
    }

    return res
}