package bitOp

fun exchangeBits(num: Int): Int {
    var a = num and 0x55555555
    var b = num and 0xaaaaaaaa.toInt()
    return (a shl 1)+(b shr 1)
}