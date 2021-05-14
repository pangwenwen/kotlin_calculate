package BitnaryTree

import listOp.p
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    var node90 = TreeNode(90)
    var node69 = TreeNode(69)
    var node49 = TreeNode(49)
    var node89 = TreeNode(89)
    var node52 = TreeNode(52)

    node90.left = node69
    node69.left = node49
    node69.right = node89
    node49.right = node52
    minDiffInBST(node90)
}

// https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
// 1. 使用递归的方法
var sub = Int.MAX_VALUE
fun minDiffInBST(root: TreeNode?): Int {
    if (root == null) return sub
    ff(root.`val`,root.right)
    ff(root.`val`,root.left)
    return sub
}

fun ff(father:Int,node: TreeNode?){
    if (node == null) return
    if (father > node.`val`){
        var cur = node
        while (cur!!.right != null){
            cur = cur.right
        }
        val temp = abs(father-cur.`val`)
        sub = min(temp, sub)
    }else{
        var cur = node
        while (cur!!.left != null){
            cur = cur.left
        }
        val temp = abs(father-cur.`val`)
        sub = min(temp, sub)
    }
    ff(node.`val`,node.right)
    ff(node.`val`,node.left)
}

// 使用中序遍历的方法
var array = ArrayDeque<Int>()
fun minDiffInBST2(root: TreeNode?): Int {
    var sub = Int.MAX_VALUE
    if (root == null) return sub
    mid(root)

    var pre = array.removeFirst()
    while (array.isNotEmpty()){
        val cur = array.removeFirst()
        sub = min(sub,pre - cur)
        pre = cur
    }
    return sub
}
fun mid(root: TreeNode?){
    if (root == null) return
    mid(root.left)
    array.push(root.`val`)
    mid(root.right)
}
