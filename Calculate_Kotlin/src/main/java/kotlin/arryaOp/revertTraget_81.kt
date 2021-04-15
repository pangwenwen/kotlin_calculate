package arryaOp

// https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/

fun main() {
    val array = intArrayOf(1,2,1)
    search81(array,3)
}
fun search81(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.lastIndex
    while (l<=r){
        if (target == nums[l] || target == nums[r]) return true

        val mid = l+((r-l) shr 1)
        if (nums[mid] == target) return true

        if (nums[mid]>nums[l]){
            if (target < nums[mid]){
                l++
                r--
            }else{
                l = mid+1
            }
        }else if (nums[mid]<nums[l]){
            if (target < nums[mid]){
                r = mid-1
            }else{
                l++
                r--
            }
        }else{
            l++
            r--
        }

    }
    return false
}