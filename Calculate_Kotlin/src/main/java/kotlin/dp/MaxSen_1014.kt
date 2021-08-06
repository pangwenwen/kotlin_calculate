package dp

// https://leetcode-cn.com/problems/best-sightseeing-pair/

fun maxScoreSightseeingPair(values: IntArray): Int {
    //  = values[i]+i + values[j]-j
    var mx = values[0]+0
    var ans = 0
    val size = values.size
    for (i in 1 until size){
        ans = Math.max(ans,mx + values[i]-i)
        mx = Math.max(mx,values[i]+i)
    }
    return ans
}