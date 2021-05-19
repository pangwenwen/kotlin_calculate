package BitnaryTree


fun main() {
//    var node1 = TreeNode(1)
//    var node2 = TreeNode(2)
//    var node3 = TreeNode(3)
//    var node4 = TreeNode(4)
//
//    node4.left = node3
//    node3.left = node2
//    node2.left = node1
//
////    buidHeightMap(node1)
////
////    for ((key,value) in map){
////        println("key is ${key.`val`}  -> $value")
////    }
//    val T = balanceBST(node4)
//    if (T != null) {
//        print(T.`val`)
//    }

    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node7 = TreeNode(7)
    var node9 = TreeNode(9)
    var node11 = TreeNode(11)
    var node12 = TreeNode(12)
    var node14 = TreeNode(14)
    var node15 = TreeNode(15)
    var node17 = TreeNode(17)

    node1.right = node15
    node15.left = node14
    node15.right = node17
    node14.left = node7
    node7.left = node2
    node7.right = node12
    node2.right = node3
    node12.left = node9
    node9.right = node11

    balanceBST(node1)
}

var listT = arrayListOf<Int>()
fun balanceBST(root: TreeNode?): TreeNode? {
    inOrderTree(root)
    if (listT.isEmpty()) return null
    return buildTree(0, listT.size-1)
}

fun inOrderTree(node:TreeNode?){
    if (node == null) return
    inOrderTree(node.left)
    list.add(node.`val`)
    inOrderTree(node.right)
}

fun buildTree(start:Int,end:Int):TreeNode?{
    if (start > end) return null
    val mid = start + ((end-start) shr 1)
    var node = TreeNode(listT[mid])

    node.left = buildTree(start,mid-1)
    node.right = buildTree(mid+1,end)

    return node
}


