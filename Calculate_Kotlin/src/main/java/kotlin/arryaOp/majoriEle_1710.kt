package arryaOp

//https://leetcode-cn.com/problems/find-majority-element-lcci/
// 摩尔投票法
fun majorityElement(nums: IntArray): Int {
    if(nums.isEmpty()) return -1
    var count = 0
    var value = -1
    for (i in nums){
        if (count == 0){
            count++
            value = i
        }else{
            if (i == value) count++
            else count--
        }
    }

    count = 0
    for (i in nums){
        if (i == value) count++
    }
    if (count > (nums.size shr 1)) return value
    return -1
}