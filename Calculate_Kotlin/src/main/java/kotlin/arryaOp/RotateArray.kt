package arryaOp

// 1.使用普通的方法，控件负责度和时间复杂度都是O(n)
fun rotate(nums: IntArray, k: Int): Unit {
    val len = nums.size
    val rotateS = k % len

    if (rotateS == 0) return

    var rotateA = IntArray(len)

    for (i in 0 until len){
        rotateA[i] = nums[(i+(len-rotateS))%len]
    }
    for (i in 0 until len){
        nums[i] = rotateA[i]
    }
}

// 看答案 数组反转  空间复杂度为1的解法
fun rotate1(nums: IntArray, k: Int): Unit {
    val len = nums.size
    val rotateS = k % len

    if (rotateS == 0) return

    reverse(nums,0,len-1)
    reverse(nums,0, rotateS-1)
    reverse(nums,rotateS, len-1)
}
private fun reverse(nums: IntArray, start: Int,end:Int){
    var p = start
    var q = end
    while (p<q){
        val temp = nums[p]
        nums[p] = nums[q]
        nums[q] = temp

        p++
        q--
    }
}




