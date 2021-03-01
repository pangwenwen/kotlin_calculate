import listOp.ListNode

// https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    if(head == null) return null
    var temp = head
    if (head.`val` == `val`){
        temp = temp.next
        return temp
    }else{
        while (temp!!.next != null ){
            if (temp.next!!.`val` == `val`){
                temp.next = temp.next!!.next
                break
            }
            temp = temp.next
        }
    }
    return head
}

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(3)
    node1.next = node2
    node2.next = node3
    deleteNode2(node1,3)

}

// 添加头结点的方法 与上面的题不是一个，上面的题不包含最后一个节点的问题
fun deleteNode2(head: ListNode?, `val`: Int): ListNode? {
    var preHead = ListNode(0)
    preHead.next = head
    var pre = preHead
    var cur = head
    while (cur != null){
        if (cur.`val` == `val`){
            pre.next = cur.next
            // 注意此处不能跳出，否则cur不会置空
//            break
        }else{
            pre = cur
        }
        cur = cur.next
    }
    return preHead.next
}

// https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
fun deleteNode(node: ListNode?) {
    if (node == null) return
    node.`val` = node.next!!.`val`
    node.next = node.next!!.next
}

