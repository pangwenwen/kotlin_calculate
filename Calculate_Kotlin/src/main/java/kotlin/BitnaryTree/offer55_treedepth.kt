package BitnaryTree

import java.util.*
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

// 2. 非递归层序遍历
fun maxDepthC(root: TreeNode?): Int {
    if (root == null) return 0
    var list = ArrayDeque<TreeNode>()
    list.add(root)
    var heigh = 0
    while (list.isNotEmpty()){
        val size = list.size
        for(i in 0 until size){
            val node = list.removeFirst()
            if (node.left != null) list.add(node.left)
            if (node.right != null) list.add(node.right)
        }
        heigh++
    }
    return heigh
}

// 3. 使用回溯法
var heigh = 0
var maxheigh = 0
fun maxDepthD(root: TreeNode?): Int {
    solDepth(root)
    return maxheigh
}
fun solDepth(node:TreeNode?){
    if (node == null ) return
    heigh++
    if (node.left == null && node.right == null)
        maxheigh = Math.max(heigh, maxheigh)

    solDepth(node.left)
    solDepth(node.right)
    heigh--
}

// 4. 使用arraydequeue + Pair
fun maxDepthE(root: TreeNode?): Int {
    if (root == null ) return 0
    var list = ArrayDeque<Pair<TreeNode,Int>>()
    list.add(Pair(root,1))

    var maxH = 0
    while (list.isNotEmpty()){
        val p = list.removeFirst()
        val node = p.first
        val h = p.second
        maxH = Math.max(maxH,h)
        if (node.left != null) list.add(Pair(node.left!!,h+1))
        if (node.right != null) list.add(Pair(node.right!!,h+1))
    }
    return maxH
}
