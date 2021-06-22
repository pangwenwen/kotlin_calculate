package bitOp
fun isPowerOfFour(n: Int): Boolean {
    return (n>0) and (n and (n-1) == 0) and (n and (0xaaaaaaaa.toInt()) == 0)
}

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums){
        res = res xor i
    }
    return res
}

// https://leetcode-cn.com/problems/find-the-difference/
fun findTheDifference(s: String, t: String): Char {
    var c = 0
    for (i in s){
        c = c xor i.toInt()
    }

    for (i in t){
        c = c xor i.toInt()
    }
    return c.toChar()
}

//https://leetcode-cn.com/problems/swap-numbers-lcci/solution/lu-ming-fei-de-zuo-ti-ri-ji-jia-jian-fa-v1wxf/
fun swapNumbers1(numbers: IntArray): IntArray {
    numbers[0]=numbers[0]+numbers[1]
    numbers[1] = numbers[0] - numbers[1]
    numbers[0] = numbers[0] - numbers[1]
    return numbers
}

fun swapNumbers2(numbers: IntArray): IntArray {
    numbers[0]=numbers[0] xor numbers[1]
    numbers[1] = numbers[0] xor numbers[1]
    numbers[0] = numbers[0] xor numbers[1]
    return numbers
}

// https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
fun countPrimeSetBits(left: Int, right: Int): Int {
    var count = 0
    for (i in left..right) {
        if (isP(Integer.bitCount(i))) {
            count++
        }
    }
    return count
}

private fun isP(count: Int): Boolean {
    return (count == 2 || count == 3 || count == 5 || count == 7 || count == 11
            || count == 13 || count == 17 || count == 19)
}




