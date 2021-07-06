package listOp

import java.util.*

// https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(3)
    var node3 = ListNode(2)

    node1.next = node2
    node2.next = node3
    reversePrint(node1)

    for (i in array){
        println("i = $i")
    }
}
var array = IntArray(0)
var count = 0
var p = 0
fun reversePrint(head: ListNode?): IntArray {
    if(head == null )  return array
    op(head)
    return array
}

fun op(node:ListNode?){
    if(node == null){
        array = IntArray(count)
        return
    }
    count++
    op(node.next)
    array[p++] = node.`val`
}

// 使用栈
fun reversePrint2(head: ListNode?): IntArray {
    if(head == null) return IntArray(0)
    var stack = ArrayDeque<Int>()
    var cur = head
    while (cur != null){
        stack.push(cur.`val`)
        cur = cur.next
    }

    var array = IntArray(stack.size)
    for (i in 0 until stack.size){
        array[i] = stack.pop()
    }
    return array

}