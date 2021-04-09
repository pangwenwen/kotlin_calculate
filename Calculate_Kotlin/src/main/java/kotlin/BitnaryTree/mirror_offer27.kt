package BitnaryTree


fun main() {
    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
//    node1.left = node2
    node1.right = node3

    val node = mirrorTree(node1)
    print(node)
}

    fun mirrorTree(root: TreeNode?): TreeNode? {
        if (root == null) return root
        if (root.left == null && root.right == null) return root
        // 注意声明临时变量记录，否则会被覆盖
        val left = root.left
        root.left = mirrorTree(root.right)
        root.right = mirrorTree(left)

        return root
    }
