package arryaOp

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    if (nums == null || nums.isEmpty() || k <=0) return false

    var map = mutableMapOf<Int,Int>()
    for (i in nums.indices){
        if (map.containsKey(nums[i])){
            val index = map[nums[i]]
            if ((i- index!!) <= k){
                return true
            }
        }
        map[nums[i]] = i

    }
    return false
}


fun findRepeatNumber(nums: IntArray): Int {
    var set = mutableSetOf<Int>()
    var res = -1
    for (i in nums){
        if (set.contains(i)){
            res = i
            break
        }
        set.add(i)
    }
    return res
}