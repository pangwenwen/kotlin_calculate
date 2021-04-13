

// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
fun main() {
    val array = intArrayOf(4,5,6,7,0,1,2)
    search(array,0)
}


fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex

    while (l < r && r<nums.size && l>=0) {
        if (target == nums[l]) {
            return l
        }
        if (target == nums[r]) {
            return r
        }

        val mid = l + ( (r-l) shr  1)
        if (nums[mid] == target) {
            return mid
        }

        if (nums[0] < nums[mid]){
            if (target > nums[0] && target<nums[mid]){
                r = mid-1
            }else{
                l = mid+1
            }
        }else{
            if (target >nums[mid]  && target<nums.last()){
                l = mid+1
            }else{
                r = mid-1
            }
        }
    }
    return -1

}


