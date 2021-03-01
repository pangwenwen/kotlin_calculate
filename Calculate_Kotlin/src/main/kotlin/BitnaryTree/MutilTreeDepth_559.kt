package BitnaryTree

//https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/

fun main() {

}

// 使用层序遍历的方法
fun maxDepth(root: Node?): Int {
    if(root == null) return 0

    var depth:Int = 0;
    var nodeList = mutableListOf<Node>()

    var temp = root
    nodeList.add(temp)

    while (!nodeList.isEmpty()){
        var size = nodeList.size

        // 循环将已有的数据遍历出其子孩子并加入，将其删除
        while (size >= 0){
            temp = nodeList[0]
            val children = temp.children
            val addSize = children.size
            if (addSize > 0){
                for (i in children){
                    nodeList.add(i!!)
                }
            }
            nodeList.remove(temp)
            size--
        }
        depth++
    }
    return depth;
}