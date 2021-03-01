package arryaOp

// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/submissions/

fun main() {
//    val arr = intArrayOf(0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75)
    val arr2 = intArrayOf(2,3,1)
    print(getLeastNumbers2(arr2,2).toString())
}

fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
    try {
        quick_sort1(arr,0,arr.size-1,k)
    }catch (e:Exception){
        return arr.take(k).toIntArray()
    }

    return arr.take(k).toIntArray()
}

fun quick_sort1(arr:IntArray,low:Int,hight:Int,k:Int){
    if (low >= hight) return
    val temp = arr[low]
    var p = low
    var q = hight
    while (p!=q){
        while (q>p && arr[q] >= temp) q--
        if (q>p){
            arr[p] = arr[q]
            p++
        }

        while (q>p &&arr[p] <= temp) p++
        if (q>p){
            arr[q] = arr[p]
            q--
        }
    }
    arr[p] = temp
    if (p == k) throw Exception("结束排序")
    quick_sort1(arr,low,p-1,k)
    quick_sort1(arr,p+1,hight,k)
}

// 使用冒泡排序
fun getLeastNumbers2(arr: IntArray, k: Int): IntArray {
    var isOk = false // 是否已经排好
    val len = arr.size
    var i = 0
    while (i<len-1){
        var j = 0
        isOk = true
        while (j<len-1-i){
            val temp1 = arr[j]
            val temp2 = arr[j+1]
            if (temp1 < temp2){
                arr[j+1] = temp1
                arr[j] = temp2
                isOk = false
            }
        }
        if (isOk) break;
        if (i == k-1) break;
        i++
    }
    return arr.takeLast(k).toIntArray()
}

