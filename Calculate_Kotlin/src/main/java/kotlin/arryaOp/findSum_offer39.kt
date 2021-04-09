package arryaOp

//https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/

fun main() {
    var array = intArrayOf(1)
    print(majorityElement2(array))
}

// 快排，然后遍历
fun majorityElement1(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    val length = nums.size

    quick_sort(nums,length-1,0)

    var temp = nums[0]-1
    var count = 0
    for (i in nums){
        if (i != temp ){
            temp = i
            count = 1
            continue
        }

        count++

        if (count > length/2)
            return i
    }
    return nums[0]-1
}

fun quick_sort(nums: IntArray,hight:Int,low:Int){
    if (low>=hight || hight>=nums.size || low<0) return
    val temp = nums[low]
    var p = hight
    var q = low

    while (p != q){
        while (p>q && nums[p] >= temp) p--;
        if (p>q){
            nums[q] = nums[p]
            q++
        }

        while (p>q && nums[q] <= temp) q++;
        if (p>q){
            nums[p] = nums[q]
            p--
        }
    }
    nums[q] = temp
    quick_sort(nums,  q - 1,low)
    quick_sort(nums,  hight,q + 1)
}

// 2.使用 hashmap
fun majorityElement2(nums: IntArray): Int {
    var map = mutableMapOf<Int,Int>()

    for (i in nums){
        if (map.containsKey(i))
            map[i] = map[i]!!.plus(1)
        else
            map.put(i,1)
        if (map[i]!! > nums.size/2)
            return i
    }

    return nums[0]-1
}

// 3. 使用投票法
// 3. 投票法
fun majorityElement3(nums: IntArray): Int {
    var num = nums[0]-1
    var count = 0
    for (i in nums){
        if (count == 0) num = i
        count += if (num === i) 1 else -1
    }

    return if (count>0) num else-1
}



