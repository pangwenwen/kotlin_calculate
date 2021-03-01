package arryaOp

fun main() {
    var array = intArrayOf(1,2,3,4)
    exchange(array)

}

fun exchange(nums: IntArray): IntArray {
    if(nums == null || nums.size<=1) return nums

    val size = nums.size
    var evenIndex = size-1 //偶数下标
    var oddIndex = 0  //奇数下标


    while (evenIndex > oddIndex){
        if (nums[oddIndex] % 2 == 0 && nums[evenIndex] % 2 == 1){
            val temp = nums[oddIndex]
            nums[oddIndex] = nums[evenIndex]
            nums[evenIndex] = temp
        }
        if (nums[oddIndex] % 2 == 1) oddIndex++
        if (nums[evenIndex] % 2 == 0) evenIndex--

    }

    return nums
}