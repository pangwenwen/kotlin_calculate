package arryaOp

fun main() {
    val array = intArrayOf(2,7,11,15)
    twoSum2(array,9)
}

// -------------------https://leetcode-cn.com/problems/two-sum/submissions/
fun twoSum2(nums: IntArray, target: Int): IntArray {
    //1. 放入map 中
    var arry = intArrayOf(-1,-1)
    var map = mutableMapOf<Int,Int>()
    for (i in nums.indices){
        val t = nums[i]
        if (map.containsKey(target-t)){
            arry[0] = i
            arry[1] = map[target-t]!!
        }
        map[nums[i]] = i
    }
    return arry
}


//一下做法不对，排序后数组下标不对应
fun twoSum(nums: IntArray, target: Int): IntArray {
    // 1. 先排序
    quick_sort(0,nums.size-1,nums)
    // 2. 先排查不合法的情况
    var arry = intArrayOf(-1,-1)
    if (nums[0] >= target || (nums[nums.size-1]+nums[nums.size-2])<target)
        return arry

    // 3. 使用双指针查找
    var start = 0;
    var end = nums.size-1
    while (start < end){
        if (nums[start]+nums[end] == target){
            arry[0] = start
            arry[1] = end
            return arry
        }else if(nums[start]+nums[end] < target){
            start++
        }else{
            end--
        }
    }
    return arry
}

fun quick_sort(left:Int,right:Int,nums: IntArray){
    if (left>right) return
    val value = nums[left]
    var l = left
    var r = right
    while (l < r){
        while (nums[r] >= value && l<r){
            r--
        }
        if (l<r){
            nums[l++] = nums[r]
        }

        while (nums[l] < value && l<r){
            l++
        }
        if (l<r){
            nums[r--] = nums[l]
        }
    }

    nums[l] = value
    quick_sort(left,l-1,nums)
    quick_sort(l+1,r,nums)
}

//------------------------https://leetcode-cn.com/problems/two-sum/submissions/
fun twoSum3(nums: IntArray, target: Int): IntArray {
    var array = intArrayOf(-1,-1)
    if (nums.size <2) return array
    var start =0;
    var end = nums.size -1
    while (start < end){
        if (nums[start]+nums[end] == target){
            array[0] = nums[start]
            array[1] = nums[end]
            return array
        }else if (nums[start]+nums[end] > target){
            end--
        }else{
            start++
        }
    }
    return array
}
