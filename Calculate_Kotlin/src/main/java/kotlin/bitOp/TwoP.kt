package bitOp

fun main() {
    isPowerOfTwo(16)
}

fun isPowerOfTwo(n: Int): Boolean {
    var tn = n
    when {
        n<=0 -> return false
        n in 1..0 -> tn = 1/n
        n == 1 -> return true
    }

    if ((tn and (tn-1)) == 0)return true
    return false
}