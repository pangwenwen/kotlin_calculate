package BitnaryTree

import listOp.ListNode

fun main() {
    var listNode1=  ListNode(1)
    var listNode2=  ListNode(2)
    var listNode3=  ListNode(3)
    listNode1.next = listNode2
    listNode2.next = listNode3
    deleteNode(listNode1,3)

}

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return null
    var node = ListNode(`val`-1)
    node.next = head
    var pre = node
    var cur = head

    while (cur != null){
        if (cur.`val` == `val`){
            pre.next = cur.next
            break
        }
        pre = cur
        cur = cur.next

    }

    return node.next
}
