package stringOp

fun main() {
    var char:Char? = null
    print(char != null)
//    isNumber(char != null)
}

fun isNumber(s: String): Boolean {
    var ts = s.trim()
    if (ts.isEmpty()) return false
    ts = ts.replace('E','e')
    var seeNum = false
    var seeDot = false
    var seeE = false
    for (i in ts.indices){
        if (ts[i] in '0'..'9')
            seeNum = true
        else if(ts[i] == '.'){
            if (seeDot || seeE) return false
            seeDot = true
        }else if (ts[i] == 'e'){
            if (!seeNum || seeE)return false
            seeE = true
            seeNum = false
        }else if (ts[i] == '+' || ts[i] == '-'){
            if (i != 0 && ts[i-1] != 'e') return false
        }else{
            return false
        }
    }
    return seeNum
}
