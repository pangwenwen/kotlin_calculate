package BitnaryTree

import kotlin.math.max

//  https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

fun main() {
    val  buildTreeNode = BuildTreeNode2()
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)

    node1.left = node2
    node1.right = node3
    node3.left = node4
    node3.right = node5

    val str = buildTreeNode.serialize(node1)
    buildTreeNode.deserialize(str)
//    print(buildTreeNode.op(node1))
}



// 不好的写法 (～￣(OO)￣)ブ
class BuildTreeNode {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String? {
        if (root == null) return null

        // 1. 先求出树的高度
        val high = op(root)
        var layer = 0

        var queue = mutableListOf<TreeNode?>()
        queue.add(root)

        var array = arrayListOf<Int?>()

        while (queue.isNotEmpty()){
            val size = queue.size
            layer++
            for (i in 0 until size){
                val node = queue.removeAt(0)
                if (node == null){
                    array.add(node)
                }else{
                    array.add(node.`val`)

                    // 添加左孩子
                    if (node.left != null)
                        queue.add(node.left!!)
                    else if (layer != high)
                        queue.add(null)

                    // 添加右孩子
                    if (node.right != null)
                        queue.add(node.right!!)
                    else if (layer != high)
                        queue.add(null)
                }

            }
        }

        var index = array.size-1
        while (index >0 && array[index] == null){
            array.remove(index--)
        }

        print(array.toString())
        return array.toString()
    }

    fun op(node:TreeNode?):Int{
        if (node == null) return 0
        return 1+ max(op(node.left),op(node.right))
    }


    // Decodes your encoded data to tree.
    fun deserialize(data: String?): TreeNode? {
        if (data == null || data.isEmpty())return null
        var array = data.map { it.toInt() } // string 转换为intarray

        var root = TreeNode(array[0])
        var lineArray = arrayListOf<TreeNode>()
        lineArray.add(root)

        val size = array.size
        var start = 1

        while (start < size){
            val size = lineArray.size
            var index = 0
            while (index < size){
                var temproot = lineArray.removeAt(0)

                val left = array[start++]
                if (left != null){
                    val lT = TreeNode(left)
                    temproot.left = lT
                    lineArray.add(lT)
                }else{
                    temproot.left = null
                }

                val right = array[start++]
                if (right != null){
                    val rT = TreeNode(right)
                    temproot.right = rT
                    lineArray.add(rT)
                }else{
                    temproot.right = null
                }
            }
        }
        return root
    }
}



class BuildTreeNode2 {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String? {
        if (root == null) return "[]"
        var queue = ArrayList<TreeNode?>()
        queue.add(root)

        var result = StringBuffer()
        result.append("[")

        while (queue.isNotEmpty()){
            val node = queue.removeAt(0)
            if (node == null){
                result.append("null,")
            }else{
                result.append(node.`val`).append(",")
                queue.add(node.left)
                queue.add(node.right)
            }
        }
        val len = result.length
        result.deleteCharAt(len-1)
        result.append("]")
        print(result.toString())
        return result.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String?): TreeNode? {
        if (data == null || data.isEmpty() || data == "[]") return null

        var array = data.substring(1 until data.length-1).split(",")
        var queue = arrayListOf<TreeNode>()

        var index = 0
        var root = TreeNode(array[index++].toInt())
        queue.add(root)
        while (queue.isNotEmpty()){
            var node = queue.removeAt(0)
            var left = array[index++]
            if ( left != "null"){
                val lT = TreeNode(left.toInt())
                node.left = lT
                queue.add(lT)
            }

            var right = array[index++]
            if (right != "null"){
                val rT = TreeNode(right.toInt())
                node.right = rT
                queue.add(rT)
            }
        }
        return root
    }
}



