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


// https://leetcode-cn.com/problems/integer-replacement/
fun integerReplacement(n: Int): Int {
    var count = 0
    return recursion(n.toLong(),count)
}

fun recursion(n: Long, count: Int): Int {
    if (n <= 1){
        return count
    }
    return if ((n % 2).toInt() == 0){
        recursion(n/2,count+1)
    }else{
        Math.min(recursion(n+1,count+1), recursion(n-1,count+1))
    }
}

// https://leetcode-cn.com/problems/add-binary/
fun addBinary(a: String?, b: String?): String? {
    if ((a == null) and (b == null)) {
        return null
    }

    val aChar = a!!.toCharArray()
    val bChar = b!!.toCharArray()
    val al = aChar.size
    val bl = bChar.size
    val macL = Math.max(al, bl)

    val resultStr = StringBuilder()

    var temp = '0'
    var aI: Char
    var bI: Char
    for (i in 1..macL) {
        if (i <= al) {
            aI = aChar[al - i]
        } else {
            aI = '0'
        }

        if (i <= bl) {
            bI = bChar[bl - i]
        } else {
            bI = '0'
        }

        if (aI == '1' && bI == '1') {
            if (temp == '1') {
                resultStr.append("1")
            } else {
                resultStr.append("0")
            }
            temp = '1'
            continue
        } else if (aI == '0' && bI == '0') {
            if (temp == '1') {
                resultStr.append("1")
            } else {
                resultStr.append("0")
            }
            temp = '0'
            continue
        } else {
            if (temp == '1') {
                temp = '1'
                resultStr.append("0")
            } else {
                resultStr.append("1")
                temp = '0'
            }
            continue
        }
    }
    if (temp == '1') {
        resultStr.append(temp)
    }
    return resultStr.reverse().toString()
}

fun main() {
    addBinary("1010","1011")
}



