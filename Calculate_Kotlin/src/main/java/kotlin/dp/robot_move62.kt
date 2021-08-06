package kotlin.dp

// https://leetcode-cn.com/problems/unique-paths/
fun uniquePaths(m: Int, n: Int): Int {
    if (m == 1 || n == 1) return 1
    var dp = Array(m){IntArray(n)}

    // dp[i][j] = dp[i-1][j] + dp[i][j-1]
    for (i in 0 until m){
        for (j in 0 until n){
            if (i == 0 && j == 0) continue
            if (j == 0 || i == 0)
                dp[i][j] = 1
            else
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

        }
    }
    return dp[m-1][n-1]
}