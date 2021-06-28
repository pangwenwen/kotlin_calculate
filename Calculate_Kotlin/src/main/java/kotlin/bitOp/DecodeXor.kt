package bitOp
//https://leetcode-cn.com/problems/decode-xored-array/
fun decode(encoded: IntArray, first: Int): IntArray {
    val size = encoded.size
    var decode = IntArray(size+1)
    decode[0] = first
    for (i in 0 until size){
        decode[i+1] = decode[i] xor encoded[i]
    }
    return decode
}