package listOp

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
// 拍好序的   可以使用1个指针没必要使用两个
fun deleteDuplicates(head: ListNode?): ListNode? {
    if(head == null) return null
    var temp = head
    var next = head.next
    while (next != null){
        if (temp!!.`val` == next.`val`){
            next = next.next
            temp.next = next
        }else{
            temp = next
            next = next.next
        }
    }
    return head
}