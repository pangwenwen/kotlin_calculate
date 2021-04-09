// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

fun main() {
    val array = intArrayOf(7,5,6,4)
    print(reversePairs(array))
}

fun reversePairs(nums: IntArray): Int {
    if(nums.size < 2) return 0
    var copy = nums.copyOf()
    var temp = IntArray(nums.size)

    return op(copy,temp,0,nums.size-1)
}

fun op(nums: IntArray, temp: IntArray, l: Int, r: Int): Int {
    if(l >= r) return 0
    val mid = l + ((r-l) shr 1)
    println("l = $l, r = $r")
    val left = op(nums,temp,l,mid)
    val right = op(nums,temp,mid+1,r)
    var count = left + right

    var i = l
    var j = mid+1
    var pos = l
    while (i<=mid && j<=r){
        if (nums[j] < nums[i]){
            temp[pos++] = nums[j++]
            count += mid+1-i
        }else{
            temp[pos++]= nums[i++]
        }
    }

    for (k in i..mid){
        temp[pos++] = nums[k]
    }
    for (k in j..r){
        temp[pos++] = nums[k]
    }


    for (m in l..r){
        nums[m] = temp[m]
    }

    return count
}