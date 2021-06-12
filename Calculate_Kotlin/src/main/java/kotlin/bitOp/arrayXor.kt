package kotlin.bitOp

fun xorOperation(n: Int, start: Int): Int {
    return 2 * getXor(start/2,start/2+n-1)+(start and 1 and n)
}

fun getXor(start: Int,end:Int):Int{
    return getXor(start-1) xor getXor(end)
}

fun getXor(n: Int): Int {
    if (0 == n % 4) return n
    if (1 == n % 4) return 1
    return if (2 == n % 4) n + 1 else 0
}
