package dp

fun main() {
    numTrees(4)
}

fun numTrees(n: Int): Int {
    if (n<=2) return n
    var dp = IntArray(n+1)
    dp[0] = 1
    dp[1] = 1
    for (i in 3..n){
        for (j in 1..i){
            dp[i] += dp[j-1] * dp[i-j]
        }

    }
    return dp[n]
}