package BitnaryTree

import java.util.*

fun main() {
    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node4 = TreeNode(4)
    var node5 = TreeNode(5)
    var node6 = TreeNode(6)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node5.right = node6

    lastPP2(node1)
}

fun prioPP(root:TreeNode?){
    if (root == null)
        return
    println(root.`val`)
    prioPP(root.left)
    prioPP(root.right)
}
fun prioPP1(root:TreeNode?){
    if (root == null)
        return
    var stack = ArrayDeque<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()){
        val node = stack.pop()
        println(node.`val`)
        if (node.right != null) stack.push(node.right)
        if (node.left != null) stack.push(node.left)
    }
}

//==========================================


fun inPP(root:TreeNode?){
    if (root == null)
        return
    inPP(root.left)
    println(root.`val`)
    inPP(root.right)
}

fun inPP2(root:TreeNode?){
    if (root == null)
        return
    var stack = ArrayDeque<TreeNode>()
    var node = root
    while (stack.isNotEmpty() || node != null){
        while (node != null){
            stack.push(node)
            node = node.left
        }
        if (stack.isNotEmpty()){
            val t = stack.pop()
            println(t.`val`)
            node = t.right
        }
    }
}

//==========================================

fun lastPP(root:TreeNode?){
    if (root == null)
        return
    lastPP(root.left)
    lastPP(root.right)
    println(root.`val`)
}

fun lastPP2(root:TreeNode?){
    if (root == null)
        return
    var stackP = ArrayDeque<TreeNode>()
    var stackC = ArrayDeque<TreeNode>()
    stackP.push(root)
    while (stackP.isNotEmpty()){
        val p = stackP.pop()
        stackC.push(p)
        if (p.left != null){
            stackP.push(p.left)
        }

        if (p.right != null){
            stackP.push(p.right)
        }
    }

    while (stackP.isNotEmpty()){
        println(stackP.pop().`val`)
    }
}

