package dp

fun tribonacci(n: Int): Int {
    if (n<2) return n
    var o = 0
    var s = 1
    var t = 1

    for (i in 3..n){
        val temp = o+s+t
        o = s
        s = t
        t = temp
    }
    return t
}