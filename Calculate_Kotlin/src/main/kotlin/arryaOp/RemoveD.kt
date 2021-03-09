package arryaOp

import kotlin.math.sign

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

fun main() {
    val nums = intArrayOf(1,2)
    println(removeDuplicates2(nums))
}

fun removeDuplicates(nums: IntArray): Int {
    if(nums == null || nums.isEmpty()) return 0
    if (nums.size == 1) return 1
    var p = 0
    var q = 0

    for (q in nums.indices){
        if (nums[p] != nums[q]){
            p++
            nums[p] = nums[q]
        }
    }
    return p+1
}

// 最多保留两个
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
fun removeDuplicates2(nums: IntArray): Int {
    if(nums == null || nums.isEmpty()) return 0
    if (nums.size == 1) return 1
    var p = 1
    var q = 1
    var after = 0
    var len = nums.size
    while (q < len){
        if (nums[p] == nums[q]){
            if (nums[after] != nums[p]) after = p++
            q++
        }else{
            if (nums[after] != nums[p] || q-p <= 1) {
                after = p++
                q++
            }else{
                after = p
                val sub = q-p
                while (q<len && p+1<len){
                    nums[++p] = nums[q++]
                }
                p = after + 1
                q = p+1
                len = len - sub + 1
            }
        }
    }
    return p+1
}

// 牛气冲天写法
fun removeDuplicates22(nums: IntArray): Int {
    if(nums == null || nums.isEmpty()) return 0
    if (nums.size <= 2) return nums.size
    var p = 0
    for(i in nums){
        if(p < 2) p++
        else{
            if (i > nums[p-2]) nums[p++] = i
        }

    }
    return p
}