package dp

// https://leetcode-cn.com/problems/coin-change/

fun main() {
    val array = intArrayOf(1,2,5)
    println(coinChange2(array,20))
}

// 1. 使用递归
fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount < 0)
        return -1
    if (amount == 0)
        return 0

    var min = Int.MAX_VALUE
    for (i in coins){
        val res = coinChange(coins,amount-i)
        if (res >= 0)
            min = Math.min(min,res+1)
    }

    if (min == Int.MAX_VALUE)
        return -1
    return min
}

// 2. 使用记忆化搜索
fun coinChange2(coins: IntArray, amount: Int): Int {
    if (amount < 0)
        return -1
    if (amount == 0)
        return 0
    var memo = IntArray(amount+1)
    coinChange2(coins,amount,memo)

    return memo[amount]
}

fun coinChange2(coins: IntArray, amount: Int,memo: IntArray): Int {
    if (amount < 0)
        return -1
    if (amount == 0)
        return 0
    if (memo[amount] != 0)
        return memo[amount]

    var min = Int.MAX_VALUE
    for (i in coins){
        val res = coinChange(coins,amount-i)
        println("amount = $amount --> res = $res")
        if (res >= 0){
            min = Math.min(min,res+1)
            println("set $amount  = $min")
            memo[amount] = min
        }
    }

    if (min == Int.MAX_VALUE){
        return -1
    }
    return min
}


// 3. 使用dp
