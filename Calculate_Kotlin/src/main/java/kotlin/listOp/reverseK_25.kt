package listOp

import listOp.ListNode

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(3)
    var node4 = ListNode(4)
    var node5 = ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    reverseKGroup(node1,3)
}

private fun revert(head:ListNode,tail:ListNode):Pair<ListNode,ListNode>{
    var pre = tail.next
    var p:ListNode? = head
    while (pre!=tail && p != null){
        var next = p.next
        p.next = pre
        pre = p
        p = next
    }
    return Pair(tail,head)
}

// 本题可转为多段整体反转
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null || k == 1) return head

    var dummy = ListNode(-1)
    dummy.next = head
    var p = dummy

    while (p.next != null){
        var one = p.next
        var tail:ListNode? = p
        for (i in 0 until k){
            tail = tail!!.next
            if (tail == null) return dummy.next
        }

        var pair = revert(one!!,tail!!)

        p.next = pair.first
        p = pair.second
    }

    return dummy.next
}