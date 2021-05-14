package BitnaryTree

import BitnaryTree.TreeNode


// https://leetcode-cn.com/problems/validate-binary-search-tree/
var list98 = mutableListOf<Int>()
fun isValidBST(root: TreeNode?): Boolean {
    inP(root)

    var t = list98[0]
    val len = list98.size
    for (i in 1 until len){
        if (t > list98[i]) return false
        t = list98[i]
    }
    return true
}

fun inP(node:TreeNode?){
    if (node == null)
        return
    inP(node.left)
    list98.add(node.`val`)
    inP(node.right)
}