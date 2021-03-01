package listOp


fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists == null || lists.isEmpty()) return null
    if (lists.size == 1) return lists[0]

    // 将头结点放入到一个数组中
    val line = lists.size
    var lineHeadArray = arrayListOf<ListNode>()
    for (i in 0 until line){
        lineHeadArray.add(lists[i]!!)
    }

    // 开始遍历每一行
    var headPre = ListNode(0)
    var hh = headPre
    while (lineHeadArray.isNotEmpty()){

        // 查找最小的头结点 行 和 结点
        var node:ListNode = ListNode(Int.MAX_VALUE)
        var index:Int = 0
        for (i in 0 until lineHeadArray.size){
            val temp1 = lineHeadArray[i]
            if (node.`val` > temp1.`val`){
                node = temp1
                index = i
            }
        }

        hh.next = node
        hh = node
        val minNext = node.next
        if (minNext == null)
            lineHeadArray.removeAt(index)
        else
            lineHeadArray[index] = minNext
    }

    return headPre.next
}