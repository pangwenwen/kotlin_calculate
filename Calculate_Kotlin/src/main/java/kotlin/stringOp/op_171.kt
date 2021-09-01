package stringOp

fun main() {
    print(titleToNumber("FXSHRXW"))
}

// https://leetcode-cn.com/problems/excel-sheet-column-number/
fun titleToNumber(columnTitle: String): Int {
    val baseSub = 64
    var revertS = columnTitle.reversed()
    val len = revertS.length
    var sum = 0
    for (i in 0 until len){
        sum += (revertS[i].toInt()-baseSub)*(Math.pow(26.0, i.toDouble()).toInt())
    }
    return sum
}