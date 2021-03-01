package Matrix

//https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

fun main() {

}

//var nums = 0
//
//fun spiralOrder(matrix: Array<IntArray>): IntArray {
//    var result = intArrayOf()
//    if(matrix == null) return result
//    val line = matrix.size
//    if (line == 0) return result
//    val col = matrix[0].size
//
//    result = intArrayOf(line*col)
//
//    var lineStart = 0
//    var lineTail = line-1
//    var colStart = 0
//    var colTail = col-1
//
//    while (lineTail >= lineStart && colTail >= colStart ){
//            // 添加上行
//            for (colIndex in colStart .. colTail){
//                setValueToArray(matrix[lineStart][colIndex],result)
//            }
//            lineStart += 1
//
//            // 添加右列
//            for (lineIndex in lineStart..lineTail){
//                setValueToArray(matrix[lineIndex][lineTail],result)
//            }
//            colTail -= 1
//
//            // 添加下行
//            for (colIndex in colTail .. colStart){
//                setValueToArray(matrix[lineStart][colIndex],result)
//            }
//            lineTail -= 1
//
//            // 添加左列
//            for (lineIndex in lineTail..lineStart){
//                setValueToArray(matrix[lineIndex][lineTail],result)
//            }
//            colStart += 1
//    }
//    return  result
//}
//
//fun setValueToArray(value:Int,array: IntArray){
//    array[nums++] = value
//}

var nums = 0

fun spiralOrder(matrix: Array<IntArray>): IntArray {
    var result = intArrayOf()
    if(matrix == null) return result
    val line = matrix.size
    if (line == 0) return result
    val col = matrix[0].size
    //1、要使用IntArray的构造方法，查看intArrayOf参数传入的元素不是size
    result = IntArray(line * col)

    var lineStart = 0
    var lineTail = line-1
    var colStart = 0
    var colTail = col-1
    while (lineTail >= lineStart && colTail >= colStart ){
        // 添加行
        for (colIndex in colStart..colTail){
            setValueToArray(matrix[lineStart][colIndex],result)
        }
        lineStart += 1
        //3、外围需要添加判断条件，防止lineTail > lineStart的情况出现越界，下面一样
        if (lineStart <= lineTail) {
            // 添加列
            for (lineIndex in lineStart..lineTail){
                setValueToArray(matrix[lineIndex][colTail],result)
            }
            colTail -= 1
        }
        //3
        if (lineStart <= lineTail && colStart <= colTail) {
            // 添加行
            //2、for...in表达式不能使用end..begin的形式，只能使用begin..end形式，下面需要重新计算一下
            for (colIndex in colStart..colTail){
                setValueToArray(matrix[lineTail][colTail - colIndex + colStart],result)
            }
            lineTail -= 1
        }
        //3
        if (lineStart <= lineTail && colStart <= colTail) {
            // 添加列
            //2
            for (lineIndex in lineStart..lineTail){
                setValueToArray(matrix[lineTail - lineIndex + lineStart][colStart],result)
            }
            colStart += 1
        }
    }
    return  result
}

fun setValueToArray(value:Int,array: IntArray){
    array[nums++] = value
}
