package BitnaryTree

import kotlin.math.max

fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)

    node1.left = node2
    node2.right = node3
    print(maxDepth(node1))

}

fun maxDepthB(root: TreeNode?): Int {
    if(root == null){
        return 0;
    }

    if (root.left==null && root.right == null){
        return 1;
    }

    return 1+max(maxDepthB(root.left), maxDepthB(root.right))
}

// 非递归使用层序遍历的方法
fun maxDepth(root: TreeNode?): Int {
    if(root == null){
        return 0;
    }

    if (root.left==null && root.right == null){
        return 1;
    }

    var node = root;
    var depthList = arrayListOf<Int>()
    depthList.add(1)
    var nodelist = arrayListOf<TreeNode>()
    nodelist.add(node)

    var temp:TreeNode
    var tempDepth:Int = 1
    while (!nodelist.isEmpty()){
        temp = nodelist.get(0);
        nodelist.remove(temp);
        tempDepth = depthList.get(0);
        depthList.removeAt(0)

        if (temp.left != null){
            nodelist.add(temp.left!!)
            depthList.add(tempDepth+1)
        }

        if (temp.right != null){
            nodelist.add(temp.right!!)
            depthList.add(tempDepth+1)
        }
    }
    return tempDepth
}
