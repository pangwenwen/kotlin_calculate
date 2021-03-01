package listOp

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(3)
    var node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null
    var pre: ListNode? = null
    var next = head
    while (next != null){
        val temp = next.next
        next.next = pre
        pre = next
        next = temp
    }
    return pre
}