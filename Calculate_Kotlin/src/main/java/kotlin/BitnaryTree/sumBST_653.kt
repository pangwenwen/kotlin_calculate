package BitnaryTree

import listOp.removeNthFromEnd
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val node5 = TreeNode(5)
    val node3 = TreeNode(3)
    val node2 = TreeNode(2)
    val node4 = TreeNode(4)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
//    node5.left = node3
//    node3.left = node2
//    node3.right = node4
//    node5.right = node6
//    node6.right = node7
    node2.right = node3


    findTarget(node2,6)
}

// https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/  BST:二叉查找树
fun findTarget(root: TreeNode?, k: Int): Boolean {
    if(root == null || (root.left==null && root.right == null)) return false

    // BST中序遍历放入到queue 中后使用双指针查找
    var t = root
    var stack = ArrayDeque<TreeNode>()
    var queue = ArrayDeque<Int>()

    while (t != null || !stack.isEmpty()){
        if (t != null){
            if (t.left != null){
                stack.push(t)
                t = t.left
                continue
            }
            queue.add(t.`val`)
            t = t.right
        }else{
            t = stack.pop()
            queue.add(t.`val`)
            t = t.right
        }
    }

    for (i in queue){
        print("$i ")
    }

    while (queue.size> 1){
        if (queue.first >= k/1+1) return false
        val value = queue.first + queue.last
        if (value <k){
            queue.removeFirst()
        }else if (value > k){
            queue.removeLast()
        }else{
            return true
        }
    }
    return false
}
