package BitnaryTree

import java.util.*

//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/

fun main() {
    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node4 = TreeNode(4)
    node1.left = node2
    node1.right = node3
    node2.right = node4
    levelOrder(node1)
}

fun levelOrder(root: TreeNode?): IntArray {
    if(root == null) return IntArray(0)

    var temp = root
    var queue = mutableListOf<TreeNode>()
    var array = mutableListOf<Int>()
    
    queue.add(temp)
    while (!queue.isEmpty()){
        // 不要忘记删除
        temp = queue.removeAt(0)
        array.add(temp.`val`)
        if (temp.left != null){
            queue.add(temp.left!!)
        }

        if (temp.right != null){
            queue.add(temp.right!!)
        }
    }
    return array.toIntArray()
}

fun levelOrder2(root: TreeNode?): List<List<Int>> {
    if(root == null) return mutableListOf<List<Int>>()
    var queue = mutableListOf<Pair<TreeNode,Int>>()
    var array = mutableListOf<List<Int>>()

    var pair:Pair<TreeNode,Int>  = Pair(root,0)
    queue.add(pair)
    while (!queue.isEmpty()){
        pair = queue.get(0)
        queue.removeAt(0)
        val node = pair.first
        val line = pair.second

        var itemList:List<Int>
        if (line >= array.size){
            itemList = mutableListOf<Int>()
            itemList.add(node.`val`)
            array.add(itemList)
        }else{
            // kotlin 直接取出来后修改后需要重新设置回去
            itemList = array[line].toMutableList()
            itemList.add(node.`val`)
            array.set(line,itemList)
        }


        if (node.left != null){
            queue.add(Pair(node.left,line+1)!! as Pair<TreeNode, Int>)
        }

        if (node.right != null){
            queue.add(Pair(node!!.right,line+1)!! as Pair<TreeNode, Int>)
        }
    }
    return array
}

fun levelOrder22(root: TreeNode?): List<List<Int>> {
    if(root == null) return mutableListOf<List<Int>>()
    var queue = mutableListOf<TreeNode>()
    var array = mutableListOf<List<Int>>()

    var temp = root
    queue.add(temp)
    while (queue.isNotEmpty()){
        val size = queue.size

        var itemList = mutableListOf<Int>()
        for (i in 0 until size){
            val node = queue.removeAt(0)
            itemList.add(node.`val`)
            if (node.left != null){
                queue.add(node.left!!)
            }
            if (node.right != null){
                queue.add(node.right!!)
            }
        }
        array.add(itemList)
    }
    return array
}

fun levelOrder3(root: TreeNode?): List<List<Int>> {
    if(root == null) return mutableListOf<List<Int>>()
    var queue = mutableListOf<Pair<TreeNode,Int>>()
    var array = mutableListOf<List<Int>>()

    var pair:Pair<TreeNode,Int>  = Pair(root,0)
    queue.add(pair)
    var fromStart = true
    while (!queue.isEmpty()){
        var node:TreeNode
        var line:Int
        if (fromStart){
            pair = queue[0]
            line = pair.second
            if (line % 2 != 0){
                pair = queue.get(queue.size-1)
                fromStart = false
            }
        }else{
            pair = queue[queue.size-1]
            line = pair.second
            if (line % 2 == 0){
                pair = queue.removeAt(0)
                fromStart = true
            }
        }
        queue.remove(pair)
        node = pair.first

        var itemList:List<Int>
        if (line >= array.size){
            itemList = mutableListOf<Int>()
            itemList.add(node.`val`)
            array.add(itemList)
        }else{
            // kotlin 直接取出来后修改后需要重新设置回去
            itemList = array[line].toMutableList()
            itemList.add(node.`val`)
            array[line] = itemList
        }

        if (fromStart){
            if (node.left != null){
                queue.add(Pair(node.left,line+1)!! as Pair<TreeNode, Int>)
            }
            if (node.right != null){
                queue.add(Pair(node.right,line+1)!! as Pair<TreeNode, Int>)
            }
        }else{
            if (node.right != null){
                queue.add(0,Pair(node.right,line+1)!! as Pair<TreeNode, Int>)
            }
            if (node.left != null){
                queue.add(0,Pair(node.left,line+1)!! as Pair<TreeNode, Int>)
            }
        }
    }

    return array
}

fun levelOrder32(root: TreeNode?): List<List<Int>> {
    if(root == null) return mutableListOf<List<Int>>()
    var queue = mutableListOf<TreeNode>()
    var array = mutableListOf<List<Int>>()

    var temp = root
    queue.add(temp)
    var lineSize = 1
    while (queue.isNotEmpty()){
        val size = queue.size

        var itemList = mutableListOf<Int>()
        var tempQueue = mutableListOf<TreeNode>()
        for (i in 0 until size){
            val node = queue.removeAt(0)
            itemList.add(node.`val`)
            if (lineSize % 2 == 0){
                if (node.right != null){
                    tempQueue.add(0,node.right!!)
                }
                if (node.left != null){
                    tempQueue.add(0,node.left!!)
                }
            }else{
                if (node.left != null){
                    tempQueue.add(0,node.left!!)
                }
                if (node.right != null){
                    tempQueue.add(0,node.right!!)
                }
            }
        }
        queue = tempQueue
        lineSize ++
        array.add(itemList)
    }
    return array
}

