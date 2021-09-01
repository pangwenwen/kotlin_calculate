
//https://leetcode-cn.com/problems/fibonacci-number/
fun fib(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    return fib(n-1)+fib(n-2)
}


fun fib2(n:Int):Int{
    if (n == 0) return 0
    if (n == 1) return 1

    var arrayInt = IntArray(n+1)
    arrayInt[0] = 0
    arrayInt[1] = 1
    var i = 2
    while (i<=n){
        arrayInt[i] = arrayInt[i-1]+arrayInt[i-2]
        i++
    }
    return arrayInt[n]
}

// https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
fun fib3(n:Int):Int{
    if(n == 0) return 0
    if (n == 1) return 1
    Int.MAX_VALUE
    var first = 0;
    var second = 1;
    for (i in 2..n){
        val third = (first+second)%1000000007
        first = second
        second = third
    }

    return second
}



fun main() {
    fibf(3)
}


fun fibf(n: Int): Int {
    if(n <= 1) return n
    var memo = IntArray(n+1)
    memo.fill(-1,0,n+1)
    memo[0] = 0
    memo[1] = 1
    return bib(memo,n)
}

private fun bib(memo:IntArray,i:Int):Int{
    if(memo[i] != -1) return memo[i]
    memo[i] = bib(memo,i-1)+bib(memo,i-2)
    return memo[i]
}