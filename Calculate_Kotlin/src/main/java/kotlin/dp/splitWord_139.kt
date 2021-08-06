package dp

fun main() {
    val str = "abcde"
    print(str.subSequence(4,5))
}

// https://leetcode-cn.com/problems/word-break/
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val len = s.length
    var dp = BooleanArray(len+1)
    dp[0] = true

    for (i in 1..len){
        for (j in 0..i){
            if (dp[j] && wordDict.contains(s.subSequence(j,i)))
                dp[i] = true
        }
    }

    return dp[len]
}
