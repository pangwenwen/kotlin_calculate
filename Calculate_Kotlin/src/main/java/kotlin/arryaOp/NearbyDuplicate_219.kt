package kotlin.arryaOp

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