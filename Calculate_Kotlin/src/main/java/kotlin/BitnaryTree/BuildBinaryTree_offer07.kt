package BitnaryTree

import BitnaryTree.TreeNode
import java.util.HashMap



fun buildTree(preorder: IntArray?, inorder: IntArray): TreeNode? {
    return if (preorder == null || preorder.size == 0) {
        null
    } else
        getChild(0, preorder, 0, inorder.size - 1, inorder)

}

private fun getChild(preIndex: Int, preorder: IntArray, inStart: Int, inEnd: Int, inorder: IntArray): TreeNode? {
    println("start = $inStart; end = $inEnd；。。。。 prIndex = $preIndex")
    if (preIndex < 0 || inStart > inEnd) {
        return null
    }
    if (inEnd == inStart) {
        return TreeNode(inorder[inStart])
    }

    val rootVal = preorder[preIndex]
    val root = TreeNode(rootVal)
    var index = inStart
    while (index <= inEnd) {
        if (inorder[index] == rootVal) {
            break
        }
        index++
    }
    if (index > inEnd) {
        return null
    }

    val len = index - inStart
    root.left = getChild(preIndex + 1, preorder, inStart, index - 1, inorder)
    root.right = getChild(preIndex + len + 1, preorder, index + 1, inEnd, inorder)
    return root
}

// 优化点  ，查找index的方式可以将其放入到hashmap中，然后在其中进行查询
private fun initMap(order: IntArray): HashMap<Int, Int> {
    val map = HashMap<Int, Int>()
    for (i in order.indices)
        map[order[i]] = i
    return map
}
