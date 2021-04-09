package arryaOp

//https://leetcode-cn.com/problems/move-zeroes/submissions/

fun moveZeroes(nums: IntArray): Unit {
    if(nums == null || nums.isEmpty() || nums.size == 1) return
    var zeroIndex = 0
    var nonZeroIndex = 0

    val len = nums.size
    while(zeroIndex<len && nonZeroIndex<len){
        if(nums[zeroIndex] == 0 && nums[nonZeroIndex] != 0){
            if (zeroIndex < nonZeroIndex) {
                nums[zeroIndex] = nums[nonZeroIndex]
                nums[nonZeroIndex] = 0
            }
            zeroIndex++
            nonZeroIndex++
            continue
        }
        if (nums[zeroIndex] != 0) zeroIndex++
        if (nonZeroIndex < zeroIndex || nums[nonZeroIndex] == 0) nonZeroIndex++
    }
}

fun main() {
    val  arr = intArrayOf(1,0)
    moveZeroes2(arr)
}

fun moveZeroes2(nums: IntArray): Unit {
    if(nums == null || nums.isEmpty() || nums.size == 1) return
    var zeroIndex = 0
    var nonZeroIndex = 0
    val len = nums.size

    while (nonZeroIndex < len){
        if (nums[nonZeroIndex] != 0){
            if (nums[zeroIndex] == 0){
                nums[zeroIndex] = nums[nonZeroIndex]
                nums[nonZeroIndex] = 0
            }
            zeroIndex++
        }
        nonZeroIndex++
    }
}