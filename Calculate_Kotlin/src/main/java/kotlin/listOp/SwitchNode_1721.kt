package listOp

fun swapNodes(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    if (k < 1) return head
    var index = 1

    var nextNode = head

    while (index<k && nextNode != null){
        nextNode = nextNode.next
        index++
    }
    // 说明长度没有n大,直接返回
    if (index < k || nextNode == null){
        return head
    }

    // 说明nextNode为最后一个值，直接替换第一个和最后一个
    if (nextNode!!.next == null){
        val headN = head.`val`
        head.`val` = nextNode.`val`
        nextNode.`val` = headN
        return head
    }
    var temp = nextNode
    var pp = head
    while (temp!!.next != null){
        pp = pp!!.next
        temp = temp.next
    }

    val preNV = nextNode.`val`
    nextNode.`val` = pp!!.`val`
    pp.`val` = preNV

    return head
}