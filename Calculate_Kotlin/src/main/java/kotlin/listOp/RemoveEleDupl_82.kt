package listOp

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(1)
    var node3 = ListNode(2)
    node1.next = node2
    node2.next = node3
    deleteDuplicates1(node1)
}

// 使用虚拟头结点  并且使用pre cur next
fun deleteDuplicates1(head: ListNode?): ListNode? {
    if (head == null) return null
    var preHead = ListNode(0)
    preHead.next = head

    var pre = preHead
    var cur = head
    var next = cur.next
    // 记录重复的值
    var value:Int = head.`val` - 1

    while (next != null){
        // 1. 前面的值与cur相等
        if (cur!!.`val` == value){
            pre.next = cur.next
            cur = next
            next = next.next
            continue
        }

        // 2. cur 与 next 同
        if (cur.`val` == next.`val`){
            value = cur.`val`
            cur = next.next
            pre.next = cur
            if (cur == null){
                break
            }
            next = next.next!!.next
            continue
        }

        // 3. 不同
        pre = cur
        cur = cur.next
        next = next.next
    }

    // 由于以上没有考虑到当cur为最后一个值时切有重复值时的情况，需要在此做处理
    if(cur != null && cur.`val`== value){
        pre.next = null
    }

    return preHead.next
}

