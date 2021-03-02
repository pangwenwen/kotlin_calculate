package arryaOp

// https://leetcode-cn.com/problems/remove-element/submissions/

fun main() {
    print("haha")
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    if (nums.isEmpty()) return 0
    var p = 0
    var q = 0
    val len = nums.size
    while (q<len){
        if (nums[q] != `val` && p != q) {
            nums[p] = nums[q]
            q++
            p++
            continue
        }
        if (nums[p] != `val`) p++
        q++
    }
    return if (p == 0) 0 else p-1

}


// 厉害写法 ୧(๑•̀◡•́๑)૭
fun removeElement1(nums: IntArray, `val`: Int): Int {
    if (nums.isEmpty()) return 0
    var p = 0
    for (i in nums.indices){
        if (nums[i] != `val`){
            nums[p] = nums[i]
            p++
        }
    }
    return p

}