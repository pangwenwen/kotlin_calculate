package BitnaryTree

// https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/

fun main() {
    var node1 = TreeNode(5)
    var node2 = TreeNode(4)
    var node3 = TreeNode(8)
    var node4 = TreeNode(11)
    var node5 = TreeNode(13)
    var node6 = TreeNode(4)
    var node7 = TreeNode(7)
    var node8 = TreeNode(2)
    var node9 = TreeNode(5)
    var node10 = TreeNode(1)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node4.left = node7;
    node4.right = node8
    node3.left = node5
    node3.right = node6
    node6.left = node9
    node6.right = node10
    pathSum(node1,22)


//    var node11 = TreeNode(-2)
//    var node12 = TreeNode(-3)
//    node11.right = node12
//    pathSum(node11,-5)


}

var pathList = mutableListOf<List<Int>>()
var sumT:Int = 0
var list = arrayListOf<Int>()
fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    findPath(root, sum)
    list.clear()
    return pathList
}

fun findPath(root: TreeNode?,target:Int){
    if (root == null) return
    val value = root.`val`
   /*
   下面这种做法会忽略掉负数的情况
    // 小于目标值直接添加并计数
    if(abs(value+ sumT) < abs(target)) {
        list.add(value)
        sumT+=value
    }else if (value + sumT == target && root.right == null && root.left == null){
       // 等于目标值 且为叶子结点 添加到list
        list.add(value)
        val temp = list.clone() as List<Int>
        pathList.add(temp)
        list.removeAt(list.size-1);
        return
    }else{
        // 大于目标值，直接返回
        return
    }
    */

    // 只要不是最后的叶子结点都需要遍历到叶子结点
    sumT+=value
    list.add(value)
    if (sumT == target && root.right == null && root.left == null){
        val temp = list.clone() as List<Int>
        pathList.add(temp)
        list.removeAt(list.size-1);
        sumT-=value
        return
    }

    findPath(root.left,target)
    findPath(root.right,target)

    sumT-=root.`val`
    list.removeAt(list.lastIndex)
}