package kotlin.BitnaryTree

import BitnaryTree.TreeNode


// https://leetcode-cn.com/problems/validate-binary-search-tree/
var list = mutableListOf<Int>()
fun isValidBST(root: TreeNode?): Boolean {
    inP(root)

    var t = list[0]
    val len = list.size
    for (i in 1 until len){
        if (t > list[i]) return false
        t = list[i]
    }
    return true
}

fun inP(node:TreeNode?){
    if (node == null)
        return
    inP(node.left)
    list.add(node.`val`)
    inP(node.right)
}