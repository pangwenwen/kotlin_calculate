package BitnaryTree

// https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
var sum = 0
fun bstToGst(root: TreeNode?): TreeNode? {
    if (root != null){
        bstToGst(root.right)
        sum += root.`val`
        root.`val` = sum
        bstToGst(root.left)
    }
    return root
}