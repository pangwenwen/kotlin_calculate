package BitnaryTree

fun isBalanced(root: TreeNode?): Boolean {
    if(root == null) return true
    return getSub(root) && isBalanced(root.left) && isBalanced(root.right)
}

fun getSub(node:TreeNode?):Boolean{
    if (node == null) return true
    var lH = getHeihg(node.left)
    var rH = getHeihg(node.right)
    return Math.abs(lH-rH)<=1
}

fun getHeihg(node: TreeNode?):Int{
    if (node == null) return 0
    return 1 + Math.max(getHeihg(node.left), getHeihg(node.right))
}