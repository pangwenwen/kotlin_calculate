package bitOp

fun decode(encoded: IntArray): IntArray {
    val size = encoded.size
    var decode = IntArray(size+1)
    // 1. 求所有值的异或结果
    var allXor = 0
    for(i in 1..size+1){
        allXor = allXor xor i
    }

    // 2. 求数组的第一个值：即所有值的异或 异或上除第一个位置的所有值，而除第一个位置所有值即为所有基数位置异或的值
    var first = allXor
    for (i in 1 until size step 2 ){
        first = first xor encoded[i]
    }

    // 3. 求decode:a^b=c ==> a^c = b
    decode[0] = first
    for (i in 0 until size){
        decode[i+1] = decode[i] xor encoded[i]
    }
    return decode
}