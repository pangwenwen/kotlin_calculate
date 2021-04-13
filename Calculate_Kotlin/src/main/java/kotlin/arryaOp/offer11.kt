package arryaOp

fun main() {
    val array = intArrayOf(2,2)
    print(findMin(array))

}

// 1. 双指针法
fun minArray(numbers: IntArray): Int {
    if(numbers == null || numbers.isEmpty()) return Int.MAX_VALUE
    if (numbers.size == 1) return  numbers[0]
    var first = 0
    var second = 1

    while (second < numbers.size){
        if (numbers[second] < numbers[first]) return numbers[second]
        second++
        first++
    }
    return numbers[0]
}

// 2.二分查找
fun findMin(numbers: IntArray): Int {
    var low = 0
    var high = numbers.size - 1
    while (low < high) {//*****
        val pivot = low + ((high - low) shr 1)
        when {
            numbers[pivot] < numbers[high] -> high = pivot
            numbers[pivot] > numbers[high] -> low = pivot + 1
            else -> high -= 1
        }
    }
    return numbers[low]
}
