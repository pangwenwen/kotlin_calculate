package arryaOp

fun main() {
    val array = intArrayOf(2,2,2,0,1)
    print(minArray(array))

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
    if(numbers == null || numbers.isEmpty()) return Int.MAX_VALUE
    if (numbers.size == 1) return  numbers[0]

    var first = 0
    var end = numbers.size-1
    if (numbers[first] < numbers[end] ) return  numbers[first]
    while (first <= end){
        val mid = first+(end-first)/2
        if (numbers[mid] > numbers[mid+1]) return numbers[mid+1]
        if (numbers[mid-1] > numbers[mid]) return numbers[mid]

        if (numbers[mid] > numbers[0]) {
            first = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return return Int.MAX_VALUE
}
