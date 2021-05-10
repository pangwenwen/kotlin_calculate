package BitnaryTree

import BitnaryTree.TreeNode

//https://leetcode-cn.com/problems/search-in-a-binary-search-tree/

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if(root == null) return null
    var cur = root
    while (cur != null){
        if (cur.`val` == `val`){
            break
        }else if (cur.`val` > `val`){
            cur = cur.left
        }else{
            cur = cur.right
        }
    }
    return cur

}


fun main() {

//    var node4 = TreeNode(4)
//    var node5 = TreeNode(5)
//    var node6 = TreeNode(6)
//    var node7 = TreeNode(7)
//    var node8 = TreeNode(8)
//    var node9 = TreeNode(9)
//
//    node4.right = node7
//    node7.left = node6
//    node7.right = node8
//    node6.left = node5
//    node8.right = node9
//
//    deleteNode(node4,7)

//    node4.left = node2
//    node2.left = node1
//    node2.right = node3
//    node4.right = node7
//
//    insertIntoBST(node4,5)

    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node4 = TreeNode(4)
    node3.left = node1
    node3.right = node4
    node1.right = node2
    deleteNode(node3,1)






}

//https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return TreeNode(`val`)

    var cur = root
    var pre:TreeNode? = null
    while (cur != null){
        pre = cur
       if (`val` > cur.`val`){
           if (cur.right != null){
               cur = cur.right
           }else{
               cur.right = TreeNode(`val`)
               return root
           }
       }else{
           if (cur.left != null){
               cur = cur.left
           }else{
               cur.left = TreeNode(`val`)
               return root
           }
       }
    }

    if (pre!!.`val` > `val`){
        pre.left = TreeNode(`val`)
    }else{
        pre.right = TreeNode(`val`)
    }

    return root
}


// https://leetcode-cn.com/problems/delete-node-in-a-bst/
fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if(root == null) return null

    var res = root
    var cur = root
    var pre:TreeNode? = null

    var removeLetf:TreeNode? = null // 要删除节点的左孩子
    var removeRight:TreeNode? = null // 要删除节点的右孩子

    while (cur != null){
        if (cur.`val` == key){
            removeLetf = cur.left
            removeRight = cur.right
            break
        }else if (cur.`val` < key){
            pre = cur
            cur = cur.right
        }else{
            pre = cur
            cur = cur.left
        }
    }

    if (removeLetf != null && removeRight != null){
        // 需要进行遍历设置左右孩子
        var temp = removeRight
        while (temp!!.left != null){
            temp = temp.left
        }
        temp.left = removeLetf
        if (pre == null){
            res = removeRight
        }else{
            if (pre.`val` > removeRight.`val`){
                pre.left = removeRight
            }else{
                pre.right = removeRight
            }
        }
    }else if (removeLetf != null){
        if (pre != null){
            if (key > removeLetf.`val`){
                pre.right = removeLetf
            }else{
                pre.right = removeLetf
            }
        }else{
            res = removeLetf
        }
    }else if(removeRight != null){
        if (pre != null){
            if (key > removeRight.`val`){
                pre.right = removeRight
            }else{
                pre.right = removeRight
            }
        }else{
            res = removeRight
        }
    }else{
        if (pre == null) res = null
        else{
            if (key > pre.`val`) pre.right = null
            else pre.left = null
        }
    }

    return res
}


