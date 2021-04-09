package nTreeOp

import java.util.*

// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/submissions/
fun levelOrder(root: Node?): List<List<Int>> {
    var list = mutableListOf<List<Int>>()
    if(root == null) return list

    var array = ArrayDeque<Node>()
    array.add(root)

    while (array.isNotEmpty()){
        val size = array.size
        var childList = mutableListOf<Int>()
        for (i in 0 until size){
            val node = array.removeFirst()
            childList.add(node.`val`)
            val children = node.children
            for (i in children){
                array.add(i)
            }
        }
        list.add(childList)
    }

    return list
}