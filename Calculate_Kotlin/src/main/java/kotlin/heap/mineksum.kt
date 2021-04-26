package kotlin.heap

import java.util.*

//https://leetcode-cn.com/problems/smallest-k-lcci/submissions/

// 1. 使用自带的优先队列
fun smallestK(arr: IntArray, k: Int): IntArray {
    if(arr == null || arr.isEmpty() || arr.size < k) intArrayOf()
    if (arr.size == k) return arr

    var priorityQueue = PriorityQueue<Int>{ i: Int, i1: Int ->
        i-i1
    }

    for (i in arr){
        priorityQueue.add(i)
    }

    var result = IntArray(k)
    for (i in 0 until k){
        result[i] = priorityQueue.remove()
    }
    return result
}

// 2. 使用自定义heap
class MyHeap(var len:Int){
    var array:IntArray = IntArray(len)
    var count:Int = 0

    fun getlChild(index:Int):Int{
        return 2*index+1
    }

    fun getrChild(index:Int):Int{
        return 2*index+2
    }

    fun getParent(index:Int):Int{
        return (index-1)/2
    }

    fun add(value:Int){
        array[count] = value
        heapUp(value)
        count++
    }

    private fun heapUp(value:Int) {
        var index = count
        while (index >0 && array[getParent(index)]>value){
            // 替换
            val p = getParent(index)
            val temp = array[p]
            array[p] = array[index]
            array[index] = temp

            // index 重新赋值
            index = p
        }
    }


    // 将最后一个元素设置到对顶，之后进行堆化
    fun remove():Int{
        val result = array[0]
        count--
        array[0] = array[count]

        heapDown()

        return result
    }

    private fun heapDown(){
        var index = 0
        while (getlChild(index) < count){
            val lI = getlChild(index)
            val rI = getrChild(index)

            var changeI = lI
            if (array[lI] < array[index] || array[rI] < array[index]){
                if (array[rI] < array[lI])
                    changeI = rI

                val temp = array[changeI]
                array[changeI] = array[index]
                array[index] = temp
                index = changeI
            }else{
                break
            }
        }
    }
}

fun smallestK2(arr: IntArray, k: Int): IntArray {
    if(arr == null || arr.isEmpty() || arr.size < k) intArrayOf()
    if (arr.size == k) return arr

    var myHeap = MyHeap(arr.size)

    for (i in arr){
        myHeap.add(i)
    }

    var result = IntArray(k)
    for (i in 0 until k){
        result[i] = myHeap.remove()
    }
    return result
}