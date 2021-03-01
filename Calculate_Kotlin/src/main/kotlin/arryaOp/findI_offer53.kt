package arryaOp

//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
fun main() {
    val array = intArrayOf(5,7,7,8,8,10)
//    print(search2(array,8))
    print(search2(array,8))
}

// 1. 使用递归完全折半查找方法
fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty() || target>nums.last()) return 0
    return find_B(0,nums.size-1,nums,target)
}

fun find_B(low:Int,hight:Int,nums: IntArray,target: Int):Int{
    if (low > hight) return 0
    val mid = low + (hight-low)/2
    if (nums[mid] > target) return find_B(low,mid-1,nums,target)
    else if (nums[mid] < target) return find_B(mid+1,hight,nums,target)
    else return 1+find_B(low,mid-1,nums,target)+find_B(mid+1,hight,nums,target)
}

// 2.使用非递归折半查找
fun search2(nums: IntArray, target: Int): Int {
    if (nums.isEmpty() || target>nums.last()) return 0
    var low = 0
    var high = nums.size-1
    var count = 0

    var mid = 0
    while (low <= high){
        mid = low+(high-low)/2
        if (nums[mid]<target) low = mid+1
        else if (nums[mid] > target) high = mid-1
        else break
    }

    // 1. 遍历查找
//    while (low<=high){
//        if (nums[low++] == target) count++
//    }
    // 2. 使用范围
    var midlow = mid
    var midhigh = mid
    while (true){
        if (nums[midlow] != target&&nums[midhigh] != target) break;
        if ((midlow >=0) && nums[midlow] == target) midlow--
        if ((midhigh <nums.size) && nums[midhigh] == target) midhigh++
    }
    val temp = midhigh-midlow-1
    count = if (temp<0) 0 else temp

    return count
}
