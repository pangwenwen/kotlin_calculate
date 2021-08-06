package dp

fun main() {
    var ary = intArrayOf(-1,-2,-3,0,1)
    print(getMaxLen(ary))
}

fun getMaxLen(nums: IntArray): Int {
    var max = 0
    var positive = 0 // +从开始到此值的最大值
    var negetive = 0 // 从开始到此为止 -的最大值

    // 1. 需要把第一个值先放进去
    if (nums[0] > 0){
        positive += 1
    }else if (nums[0] <0){
        negetive += 1
    }

    for (i in 1 until nums.size){
        // 在下面处理的时候看答案写的
        if(nums[i] > 0){
            positive++
            negetive = if(negetive >0) negetive+1 else 0
        }else if( nums[i]== 0){
            positive = 0
            negetive = 0
        }else{
            val temp = positive
            positive = if(negetive >0) negetive+1 else 0
            negetive = temp+1
        }

        max = Math.max(positive,max)
    }
    return Math.max(positive,max)
}

//for (int i = 1; i < length; i++) {
//    if (nums[i] > 0) {
//        positive[i] = positive[i - 1] + 1;
//        negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
//    } else if (nums[i] < 0) {
//        positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
//        negative[i] = positive[i - 1] + 1;
//    } else {
//        positive[i] = 0;
//        negative[i] = 0;
//    }
//    maxLength = Math.max(maxLength, positive[i]);
//}