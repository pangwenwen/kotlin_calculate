package nTreeOp

import java.util.*

// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/submissions/

var plist = mutableListOf<Int>()
fun postorder(root: Node?): List<Int> {
    postOp(root)
    return list
}

fun postOp(node: Node?) {
    if (node == null) return
    val children = node.children
    children?.let {
        for (i in children)
            postOp(i)
    }
    plist.add(node.`val`)
}

fun main() {
    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)
    var node4 = Node(4)
    var list1 = listOf<Node>(node3, node2, node4)
    node1.children = list1
    postorder2(node1)
}


// 非递归
fun postorder2(root: Node?): List<Int> {
    var plist = mutableListOf<Int>()
    if (root == null) return plist
    var stack = ArrayDeque<Node>()
    stack.add(root)

    var node = root
    while (node != null) {
        var children = node.children
        if (children != null && children.isNotEmpty()) {
            val firstC = children[0]
            stack.add(firstC)
            children -= firstC
            node.children = children
            node = firstC
        } else {
            plist.add(node.`val`)
            val temp = stack.last
            if (temp.children == null || temp.children.isEmpty()) {
                stack.removeLast()
                if (stack.isEmpty()) {
                    node = null
                } else {
                    node = stack.last
                }

            }
        }

    }
    return plist
}