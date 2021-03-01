package listOp

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(2)
    node1.next = node2
    reverseBetween(node1,1,2)
}

fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    if (head == null || m > n) return head
    var index = 1
    var pre:ListNode? = null
    var next:ListNode? = head

    while (index < m){
        pre = next
        next = next!!.next
        index++
    }

    // 说明长度不够  不需要加 ，条件中有限制
    // if (next == null) return null

    var revertPre: ListNode? = pre
    var startRevert:ListNode? = next

    pre = next
    next = next!!.next

    while (index < n){
        var temp = next!!.next
        next.next = pre
        pre = next
        next = temp
        index++
    }
    var tt = head
    // 遍历完毕后next为需要旋转后的第一个
    if(revertPre != null)
        revertPre!!.next = pre
    else
        tt = pre

    startRevert!!.next = next
    return tt
}