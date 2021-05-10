package BitnaryTree

// 二叉搜索树
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if(root == null || (root.left == null &&root.right == null)) return null
    if (p == null || q == null) return null

    var ancestor = root
    while (ancestor != null){
        ancestor = if (p.`val` <ancestor.`val` && q.`val`<ancestor.`val`) ancestor.left
        else if (p.`val` > ancestor.`val` && q.`val` > ancestor.`val`) ancestor.right
        else break
    }

    return ancestor
}

fun main() {
    var node0 =  TreeNode(0)
    var node1 =  TreeNode(1)
    var node2 =  TreeNode(2)
    var node3 =  TreeNode(3)
    var node4 =  TreeNode(4)
    var node5 =  TreeNode(5)
    var node6=  TreeNode(6)
    var node7=  TreeNode(7)
    var node8=  TreeNode(8)

    node3.left = node5
    node5.left = node6
    node5.right = node2
    node2.left = node7
    node2.right = node4
    node3.right = node1
    node1.left = node0
    node1.right = node8

    lowestCommonAncestor2(node3,node5,node1)
}

// 二叉树
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if(root == null || (root.left == null &&root.right == null)) return null
    if (p == null || q == null) return null
    findAncestor(root,p,q)
    return ancestor
}

var ancestor:TreeNode? = null

fun findAncestor(root: TreeNode?, p: TreeNode, q: TreeNode):Boolean{
    if (root == null) return false
    val leT = findAncestor(root.left,p,q)
    val riT = findAncestor(root.right,p,q)

    if ((leT && riT) || (leT || riT) && (root.`val` == p.`val` || root.`val` ==q.`val`))
        ancestor = root
    return leT || riT || root.`val` === p.`val` || root.`val` === q.`val`
}

