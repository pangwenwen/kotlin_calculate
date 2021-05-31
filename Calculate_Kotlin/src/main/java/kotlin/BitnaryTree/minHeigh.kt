package BitnaryTree

import java.util.*

fun main() {
    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node4 = TreeNode(4)

    node1.left = node2
    node2.left = node3
    node3.right = node4
    minDepth(node1)
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left != null)
        return 1+ minDepth(root.left)
    if (root.right != null)
        return 1+ minDepth(root.right)
    return 1+Math.min(minDepth(root.left), minDepth(root.right))
}

//BFS
fun minDepth2(root: TreeNode?): Int {
    if (root == null) return 0
    var array = ArrayDeque<TreeNode>()
    array.add(root)
    var depth = 0
    while (array.isNotEmpty()){
        depth++
        val size = array.size

        for (i in 0 until size){
            val node = array.removeFirst()
            if (node.left == null && node.right == null){
                return depth
            }
            if (node.left != null){
                array.add(node.left)
            }
            if (node.right != null){
                array.add(node.right)
            }
        }

    }
    return depth
}

//DFS
fun minDepth3(root: TreeNode?): Int {
    if (root == null) return 0
    var array = ArrayDeque<Pair<TreeNode,Int>>()
    array.add(Pair(root,1))
    var depth = Int.MAX_VALUE
    while (array.isNotEmpty()){
        val pair = array.removeFirst()
        val node = pair.first
        val heigh = pair.second
        if (node.right == null && node.left == null){
            depth = Math.min(depth,heigh)
            break
        }

        if (node.left != null){
            array.add(Pair(node.left!!,heigh+1))
        }

        if (node.right != null){
            array.add(Pair(node.right!!,heigh+1))
        }

    }
    return depth
}