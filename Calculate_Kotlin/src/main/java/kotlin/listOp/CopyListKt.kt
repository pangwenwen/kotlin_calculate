package listOp

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun main() {
    val node1 = Node(7)
    val node2 = Node(13)
    val node3 = Node(11)
    val node4 = Node(10)
    val node5 = Node(1)

    node1.next = node2
    node1.random = null

    node2.next = node3
    node2.random = node1

    node3.next = node4
    node3.random = node5

    node4.next = node5
    node4.random = node3

    node5.next = null
    node5.random = node1

    copyRandomList(node1)
}

fun copyRandomList(head: Node?): Node? {
    if (head == null) return null

    val preHead = Node(0)
    var temp = head
    var newN: Node? = Node(0)
    preHead.next = newN

    var mapKV = mutableMapOf<Node?,Node?>()

    // 设置next
    while (temp != null) {
        newN!!.`val` = temp.`val`

        var next = temp.next
        if (next != null) {
            next = Node(next.`val`)
        }
        newN.next = next

        mapKV.set(temp,newN)

        newN = next
        temp = temp.next
    }

    // 设置random
    temp = head
    var temp1 = preHead.next
    while (temp != null){
        var random = temp.random
        if (random != null) {
            random = mapKV.get(random)
            temp1!!.random = random
        }else{
            temp1!!.random = null
        }

        temp = temp.next
        temp1 = temp1.next
    }

    return preHead.next
}