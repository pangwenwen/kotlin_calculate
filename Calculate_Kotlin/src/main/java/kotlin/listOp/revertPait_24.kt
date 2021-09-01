package listOp

import listOp.ListNode

fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    // 对于此题我们最好声明头结点，因为如果不声明还需要判断头结点和非头结点的问题
    var dummy = ListNode(-1)
    dummy.next = head
    var p = dummy

    while (p?.next?.next != null){
        var one = p.next
        var two = one!!.next
        var next = two!!.next

        p.next = two
        two.next = one
        one.next = next

        p = one
    }
    return dummy.next
}