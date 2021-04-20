package kotlin.arryaOp

fun containsDuplicate(nums: IntArray): Boolean {
    if(nums == null || nums.size < 2) return false
    var setT = mutableSetOf<Int>()
    for (i in nums){
        if (setT.contains(i)) return true
        setT.add(i)
    }
    return false
}

fun containsDuplicate2(nums: IntArray): Boolean {
    if(nums == null || nums.size < 2) return false
    var mapI = mutableMapOf<Int,Int>()
    for (i in nums){
        if (mapI.containsKey(i)) return true
        mapI[i] = 0
    }
    return false
}
