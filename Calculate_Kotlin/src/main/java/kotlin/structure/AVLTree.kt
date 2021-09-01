package structure

internal class TreeNode {
    var `val`: Int = 0
    var height = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor() {}
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, left: TreeNode, right: TreeNode) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}


internal class AVL {
    var root: TreeNode? = null

    fun addNode(value: Int): TreeNode? {
        if (root == null) {
            root = TreeNode(value)
            root!!.height = 1
            return root
        }
        root = addNode(root, value)
        return root
    }

    private fun addNode(node: TreeNode?, value: Int): TreeNode? {
        var node = node
        if (node == null) {
            val newN = TreeNode(value)
            newN.height = 1
            return newN
        }
        if (node.`val` > value) {
            node.left = addNode(node.left, value)
        } else {
            node.right = addNode(node.right, value)
        }

        node.height = getHeight(node)

        if (getF(node) > 1 && getF(node.left) > 0) {// 右旋
            node = rightRotate(node)
        }
        if (node != null) {
            if (getF(node) > 1 && getF(node.left) < 0) {// 先左后右旋
                val t = node.left?.let { leftRotate(it) }
                node.left = t
                node = rightRotate(node)
            }
        }

        if (node != null) {
            if (getF(node) < -1 && getF(node.right) < 0) {// 左旋
                node = leftRotate(node)
            }
        }

        if (node != null) {
            if (getF(node) < -1 && getF(node.right) > 0) {// 先右后左旋
                val t = node.right?.let { rightRotate(it) }
                node.right = t
                node = leftRotate(node)
            }
        }
        return node
    }

    private fun rightRotate(node: TreeNode): TreeNode? {
        val x = node.left
        val y = x?.right
        if (x != null) {
            x.right = node
        }
        node.left = y

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right))
        if (x != null) {
            x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left))
        }

        return x
    }

    private fun leftRotate(node: TreeNode): TreeNode? {
        val x = node.right
        val y = x?.left
        if (x != null) {
            x.left = node
        }
        node.right = y

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right))
        if (x != null) {
            x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left))
        }

        return x
    }

    private fun getF(node: TreeNode?): Int {
        return if (node == null) 0 else getHeight(node.left) - getHeight(node.right)
    }

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null) return 1
        return if (node.left == null)
            1 + (node.right?.height ?: 0)
        else if (node.right == null)
            1 + node.left!!.height
        else
            1 + Math.max(node.left!!.height, node.right!!.height)
    }
}