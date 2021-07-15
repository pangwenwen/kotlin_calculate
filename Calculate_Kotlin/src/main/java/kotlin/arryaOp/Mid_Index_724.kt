package kotlin.arryaOp

fun pivotIndex(nums: IntArray): Int {
    val size = nums.size
    var sumA = IntArray(size)

    // 1. 求前缀和
    for (i in nums.indices){
        if (i == 0){
            sumA[i] = nums[i]
        }else{
            sumA[i] = sumA[i-1]+nums[i]
        }
    }

    // 2. 如果前缀和的第一个值和最后一个值相同则说明第一个值之后的值相加后为0，
    // 则中心下标为0
    if (sumA[0] == sumA[size-1]) return 0

    // 3. 查找最后一个值减前缀和，如果减之后的值为他的下一个值则中位值为其下一个值
    // 2A+B - A = A + B (A为相等的部分，B为中位值)
    val last = sumA[size-1]
    for (i in 0 until size-1){
        if (last-sumA[i] == sumA[i+1])
            return i+1
    }

    // 4. 处理中位值为最后一个值的情况
    if (sumA[size-2] == 0) return size-1

    return -1
}