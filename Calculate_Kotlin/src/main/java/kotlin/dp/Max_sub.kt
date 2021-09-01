package dp

fun longestCommonSubsequence(text1: String, text2: String): Int {
    if(text1.isEmpty() || text2.isEmpty()) return 0
    if (text1 == text2) return text1.length

    val len1 = text1.length
    val len2 = text2.length

    var max = 0
    var dp = Array(len1+1) { IntArray(len2+1)}
    for (i in 1..len1){
        for (j in 1..len2){
            if (text1[i-1] == text2[j-1]){
                dp[i][j] = dp[i-1][j-1]+1
                max = Math.max(dp[i][j],max)
            }else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
            }
        }
    }
    return max
}

fun main() {
    var t1 = "hahah"
    var t2 = "hahah"
    print(t1==t2)
}