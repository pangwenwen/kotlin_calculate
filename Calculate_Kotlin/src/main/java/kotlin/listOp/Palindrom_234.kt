package listOp

fun main() {
    var node1 = ListNode(0)
    var node2 = ListNode(0)
    node1.next = node2
    print(isPalindrome(node1))
}

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    var preHead = ListNode(0);
    preHead.next = head
    var oneStepN: ListNode? = preHead
    var twoStepN: ListNode? = preHead

    while (twoStepN?.next != null) {
        oneStepN = oneStepN!!.next
        twoStepN = twoStepN!!.next!!.next
    }

    var pre = oneStepN
    var next = oneStepN!!.next
    while (next != null) {
        var temp = next.next
        next.next = pre
        pre = next
        next = temp
    }
    var tempHead = head

    while (pre != tempHead && tempHead!!.next != pre) {
        if (tempHead!!.`val` == pre!!.`val`) {
            tempHead = tempHead.next
            pre = pre.next
        } else {
            return false
        }
    }


    if (pre != null) {
        if (tempHead!!.`val` != pre.`val`) return false
    }


    return true
}