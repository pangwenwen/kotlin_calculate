
// https://leetcode-cn.com/problems/integer-to-roman/
fun intToRoman(num: Int): String {
    // 构建map
    val map = mapOf<Int,String>(1 to "I",5 to "V",10 to "X",50 to "L",100 to "C",500 to "D",1000 to "M")
    var ob = StringBuffer()

    var temp = num
    var j = 1
    while (temp > 0){
        val a = temp % 10
        val b = a % 5
        val c = a / 5
        if (b == 4){
            if (c == 0) ob.append(map[j*5])
            else ob.append(map[j*10])
            ob.append(map[j])
        }else{
            for (len in 1..b){
                ob.append(map[j])
            }
            if (c == 1)ob.append(map[j*5])
        }

        temp /= 10
        j *= 10
    }

    return ob.reverse().toString()
}

// -----------------题解  -- 贪心算法
fun intToRoman2(num: Int):String{
    val values = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val symbols = arrayOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
    var i = 0
    var sb = StringBuffer()
    var temp = num
    while (i <values.size && temp>=0){
        while (values[i] <= temp){
            temp -= values[i]
            sb.append(symbols[i])
        }
        i++
    }
    return sb.toString()
}