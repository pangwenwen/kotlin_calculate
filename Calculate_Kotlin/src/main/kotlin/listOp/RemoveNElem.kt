package listOp

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var nNode = head
    var preHead = ListNode(0)
    preHead.next = head
    var count = 0

    while (nNode != null){
        nNode = nNode.next
        if (++count == n){
            break
        }
    }

    // 表明 n  比list的长度大，直接返回
    if (nNode == null && count < n){
        return head
    }

    // 说明删除的是头结点
    if (nNode == null && count == n){
        preHead.next = preHead!!.next!!.next
        return preHead.next
    }

    var nPre = head
    while (nNode!!.next != null){
        nPre = nPre!!.next
        nNode = nNode!!.next
    }
    nPre!!.next = nPre!!.next!!.next
    return preHead.next
}