package dp

fun maxProfit21(prices: IntArray): Int {
    var res = 0
    val size = prices.size
    var dp = IntArray(size) // dp[i] 存储的是 i的位置获利最大
    for (i in 1 until size){
        for (j in 0 until i){
            dp[i] = Math.max(dp[i],(prices[i]-prices[j])+dp[j])
        }
        dp[i] = Math.max(dp[i-1],dp[i])
    }
    return res
}

fun maxProfit22(prices: IntArray): Int {
    var res = 0
    val size = prices.size

    for (i in 0 until size-1){
       if (prices[i+1] - prices[i] > 0) res += prices[i+1] - prices[i]
    }
    return res
}

fun maxProfit1(prices: IntArray): Int {
    val size = prices.size
    if(size == 1) return 0
    var min = prices[0] //记录遍历到n时最小的值
    var res = 0
    for(i in 1 until size){
        if(min > prices[i]){
            min = prices[i]
        }else{
            res = Math.max(res,prices[i] - min)
        }
    }
    return res
}
