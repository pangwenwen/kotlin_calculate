package kotlin.bitOp
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