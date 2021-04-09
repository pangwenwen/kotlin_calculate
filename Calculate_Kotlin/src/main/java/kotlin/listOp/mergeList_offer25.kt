package listOp

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2

    var newnode = ListNode(0)
    var temp = newnode

    while (p1 != null && p2 != null){
        if (p1.`val` > p2.`val`){
            temp.next = p1
            p1 = p1.next
        }else{
            temp.next = p2
            p2 = p2.next
        }
        temp = temp.next!!
    }
    
    if (p1 != null) temp.next = p1
    if (p2 != null) temp.next = p2
    
    return newnode.next
}