package bitOp

import java.util.*

fun main() {
    val array = intArrayOf(1024,512,256,128,64,32,16,8,4,2,1)
    sortByBits(array)
}

fun sortByBits(arr: IntArray): IntArray {
    if (arr.size ==1 )return arr
    var map = mutableMapOf<Int,PriorityQueue<Int>>()
    var dump = PriorityQueue<Int>{ i: Int, i1: Int ->
        i-i1
    }

    for (i in arr){
        val bit = hammingWeight(i)
        if (!dump.contains(bit))
            dump.add(bit)

        var queue = map[bit]
        if (queue == null){
            var tQ = PriorityQueue<Int>{i: Int, i1: Int ->
                i-i1
            }
            tQ.add(i)
            map[bit] =  tQ
        }else{
            queue.add(i)
            map[bit] = queue
        }
    }

    var que = ArrayDeque<Int>()
    while (dump.isNotEmpty()){
        val bit = dump.remove()
        var innerDum = map[bit]!!
        while (innerDum.isNotEmpty()){
            que.add(innerDum.remove())
        }
    }
    return que.toIntArray()
}

fun hammingWeight1(n:Int):Int {
    if (n == 0) return 0
    var count = 0
    var t = n
    while ((t and (t-1)) != 0){
        count++
        t = t and (t-1)
    }
    return count+1
}