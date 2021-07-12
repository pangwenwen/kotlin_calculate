package structure

import java.lang.IllegalArgumentException
import java.util.*

fun main() {
    val array = intArrayOf(-2,0,3,-5,2,-1)
    val numArray = NumArray(array)
    numArray.sumRange(1,3)
}

class NumArray(nums: IntArray) {
    var segmentTree = SegmentTree(nums)
    fun sumRange(left: Int, right: Int): Int {
        segmentTree.buildTree()
        return segmentTree.getRange(left,right)
    }

}

class SegmentTree(nums:IntArray){
    var datas = nums.copyOf(nums.size)
    var treeArray = IntArray(nums.size * 4)

    fun buildTree(){
        build(0, 0, datas.size-1)
    }

    private fun build(index:Int,left:Int,right:Int){
        if (left == right){
            treeArray[index] = datas[left]
            return
        }
        val leftIndex = getLeft(index)
        val rightIndex = getRight(index)
        val mid = left + ((right-left) ushr 1)
        build(leftIndex,left,mid)
        build(rightIndex,mid+1,right)
        treeArray[index] = treeArray[leftIndex]+treeArray[rightIndex]
    }

    fun getRange(left: Int,right: Int):Int{
        if (left<0 || right>datas.size || left>right)
            throw IllegalArgumentException("参数和合法")

        return getRange(0,0,datas.size,left,right)
    }
    private fun getRange(treeIndex:Int,dataL:Int,dataR:Int,queryL: Int,queryR: Int):Int{
        if (dataL == queryL && dataR == queryR) return treeArray[treeIndex]
        val mid = dataL + ((dataR-dataL) ushr 1)
        val leftIndex = getLeft(treeIndex)
        val rightIndex = getRight(treeIndex)
        if (queryL>mid)
            return getRange(rightIndex,mid+1,dataR,queryL,queryR)
        else if(queryR <= mid)
            return getRange(leftIndex,dataL,mid,queryL,queryR)

        val leftR = getRange(leftIndex,dataL,mid,queryL,mid)
        val rightR = getRange(rightIndex,mid+1,dataR,mid+1,queryR)
        return leftR+rightR
    }


    private fun getLeft(index:Int):Int{
        return 2 * index + 1
    }
    private fun getRight(index:Int):Int{
        return 2 * index + 2
    }

}