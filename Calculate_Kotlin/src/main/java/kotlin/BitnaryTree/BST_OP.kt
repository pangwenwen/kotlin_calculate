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

    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node4 = TreeNode(4)
    node3.left = node1
    node3.right = node4
    node1.right = node2
//    deleteNode(node3,1)

    print(findMin(node3).`val`)






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

fun deleteNode2(root: TreeNode?, key: Int): TreeNode? {
    if(root == null) return null
    when {
        key < root.`val` -> root.left = deleteNode2(root.left, key)
        key > root.`val` -> root.right = deleteNode2(root.right,key)
        else ->
            /*
            1. 左孩子为空，右孩子不为空
            2. 左孩子不为空，右孩子为空
            3. 左、右孩子都不为空
            */
            when {
                root.left == null -> {
                    val right = root.right
                    root.right = null
                    return right
                }
                root.right == null -> {
                    val left = root.left
                    root.left = null
                    return left
                }
                else -> {
                    var rightmin = findMin(root.right!!)
                    rightmin.right = removeMinAndgetRoot(root.right!!)
                    rightmin.left = root.left
                    root.left = null
                    root.right = null
                    return rightmin
                }
            }
    }
    return root
}

fun removeMinAndgetRoot(node: TreeNode): TreeNode? {
    if (node.left == null){
        var right = node.right
        node.right = null
        return right
    }
    node.left = removeMinAndgetRoot(node.left!!)
    return node
}

fun findMin(node: TreeNode): TreeNode {
    if (node.left == null)
        return node
    return findMin(node.left!!)
}


