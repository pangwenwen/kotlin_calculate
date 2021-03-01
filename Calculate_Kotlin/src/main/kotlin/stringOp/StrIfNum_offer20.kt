package stringOp

fun main() {
    var char:Char? = null
    print(char != null)
//    isNumber(char != null)
}

fun isNumber(s: String): Boolean {
    if (s== null || s.trim().isBlank()) return false
    val charA = s.trim().toCharArray()
    if(isPoint(charA[0])) return false
    var pre: Char? = null

    for (c in charA){
        val isN = isNum(c)
        val isE = isE(c)
        val isP = isPoint(c)
        val isO = isOperate(c)

        if (!isN && !isE && !isP && !isO) return false // 如果不在四类范围中直接返回false

        if (isE){
            if (!isNum(pre)) return false
        }else if (isP){
            if (!(pre == null || isNum(pre))) return false
        }else if (isO){
            if (pre != null ) return false
        }
        pre = c
    }
    if (isE(pre) || isOperate(pre)) return false
    return true
}

fun isNum(c:Char?): Boolean {
    if (c != null) {
        return c.toInt() in 48..57
    }
    return false
}

fun isE(c:Char?):Boolean{
    return c=='e' || c == 'E'
}

fun isPoint(c:Char?):Boolean{
    return c == '.'
}

fun isOperate(c:Char?):Boolean{
    return c == '-'|| c == '+'
}

