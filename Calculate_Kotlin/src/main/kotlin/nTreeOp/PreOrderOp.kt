package nTreeOp

import java.util.*

// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
// 1. 使用递归
var list = mutableListOf<Int>()
fun preorder(root: Node?): List<Int> {
    if (root == null) return list
    order(root)
    return list
}

fun order(node:Node?){
    if (node == null) return
    list.add(node.`val`)
    val childs = node.children
    childs?.let {
        for (i in it){
            order(i)
        }
    }
}

fun main() {
    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)
    var node4 = Node(4)
    var node5 = Node(5)
    var node6 = Node(6)

    var list1 = listOf<Node>(node3,node2,node4)
    var list2 = listOf<Node>(node5,node6)
    node1.children = list1
    node3.children = list2
    preorder3(node1)
}
// 2. 非递归  -- (～￣(OO)￣)ブ 笨方法
fun preorder2(root: Node?): List<Int> {
    var list = mutableListOf<Int>()
    if (root == null) return list
    var stack = ArrayDeque<List<Node?>>()

    var node = root
    while (node!=null || !stack.isEmpty()){
        if (node != null){
            list.add(node.`val`)
            var child = node.children
            if (child.isNotEmpty()){
                node = child[0]
                child -= node
                if (child.isNotEmpty()){
                    stack.add(child)
                }
                continue
            }
        }
        try {
            var child2 = stack.removeLast()
            node = child2[0]
            child2 -= node
            if (child2.isNotEmpty()){
                stack.add(child2)
            }
        }catch (e:NoSuchElementException){
            // 取不到值的时候就结束
            node = null
            break
        }

    }
    return list
}

// 3.
fun preorder3(root: Node?): List<Int> {
    var list = mutableListOf<Int>()
    if (root == null) return list
    var stack = ArrayDeque<Node>()

    stack.add(root)
    while (stack.isNotEmpty()){
        val node = stack.removeLast()
        list.add(node.`val`)

        node.children?.let {
            val size = it.size-1
            var index = size
            while (index >=0){
                stack.add(it[index--])
            }
        }
    }
    return list
}

