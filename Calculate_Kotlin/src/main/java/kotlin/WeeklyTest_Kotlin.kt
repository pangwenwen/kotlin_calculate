
import BitnaryTree.TreeNode
import listOp.ListNode
import java.util.*

// 20210517 中序后续构建二叉树
// https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    if(inorder.size != postorder.size) return null
    buildMap(inorder)
    var root:TreeNode?= null
    try {
        root = buildTree(inorder,0,inorder.size-1,postorder,0,postorder.size-1)
    }catch (e:Exception){
        print(e.toString())
    }
    return root
}

// 优化查找的时间复杂度
var map = mutableMapOf<Int,Int>()
fun buildMap(inorder: IntArray) {
    for (i in inorder.indices){
        map[inorder[i]] = i
    }
}

fun buildTree(inorder: IntArray,inStart:Int,inEnd:Int, postorder: IntArray,postStart:Int,postEnd:Int):TreeNode?{
    if (inStart > inEnd || postStart > postEnd) return null
    val value = postorder[postEnd]
    var root = TreeNode(value)
    val index = map[value] ?: throw RuntimeException("没有找到元素")
    val sub = index-inStart
    root.left = buildTree(inorder,inStart,index-1,postorder,postStart,postStart+sub-1)
    root.right = buildTree(inorder,index+1,inEnd,postorder,postStart+sub,postEnd-1)
    return root
}

fun depth(root:TreeNode?):Int{
    if(root == null) return 0
    var list = arrayListOf<TreeNode>()
    var hight = 0
    list.add(root)
    while (list.isNotEmpty()){
        val size = list.size
        for (i in 0 until size){
            val temp = list.removeAt(0)
            if (temp.left != null){
                list.add(temp.left!!)
            }

            if (temp.right != null){
                list.add(temp.right!!)
            }

        }
        hight++
    }
    return hight
}


// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) return head
    var temp = head!!
    while (temp.next != null){
        val next = temp.next!!
        if (next.`val` == temp.`val`){
            temp.next = next.next
            next.next = null
        }else{
            temp = next
        }
    }
    return head
}

//fun main(){
//    var node1 = ListNode(1)
//    var node2 = ListNode(1)
//    var node3 = ListNode(3)
//    var node4 = ListNode(5)
//    var node5 = ListNode(5)
//
//    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//
//    deleteDuplicates1(node1)
//
//}

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
fun deleteDuplicates1(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var pre = ListNode(head.`val`-1)
    var tt = head
    pre.next = tt

    var preT = pre
    var headT = head

    while (headT != null && headT.next != null){
        // 如果相等直接往后移动headT
        if (headT.`val` == headT.next!!.`val`){
            headT = headT.next!!
            continue
        }

        // 不相同
        if (preT.next == headT){
            preT = headT
            headT = headT.next
        }else{
            preT.next = headT.next!!
            headT = preT.next
        }
    }

    if (preT.next != headT) preT.next = null
    return pre.next

}

lateinit var isVisted:Array<BooleanArray>
var index = 0
fun exist(board: Array<CharArray>, word: String): Boolean {
    if(board == null || word == null || board.size * board[0].size < board.size) return false

    val col = board.size
    val low = board[0].size

    isVisted = Array(col, init = {BooleanArray(low)})
    for (i in 0 until col){
        for (j in 0 until low){
            if (find(board,i,j,word)){
                return true
            }
        }
    }
    return false
}

fun find(board: Array<CharArray>,x:Int,y:Int, word: String):Boolean{
    if (index >= word.length) return true

    if (x >= board.size || x<0 || y>board[0].size || y<0) return false
    if (isVisted[x][y]) return false
    if (board[x][y] != word[index]) return false

    isVisted[x][y] = true
    index++
    var isOk = find(board,x+1,y,word) || find(board,x-1,y,word)|| find(board,x,y+1,word) || find(board,x,y-1,word)

    isVisted[x][y] = false
    index--
    return isOk
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) return null
    var dummy = ListNode(0)
    var p = dummy

    var l1T = l1
    var l2T = l2
    while (l1T!= null && l2T!= null){
        if (l1T.`val` <= l2T.`val`) {
            p.next = l1T
            l1T = l1T.next
        }else{
            p.next = l2T
            l2T = l2T.next
        }
        p = p.next!!
    }
    p.next = l1T ?: l2T
    return dummy.next
}

fun swapNodes(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    var first:ListNode? = null
    var second:ListNode? = null
    var count = 1
    var cur = head
    while (cur != null){
        if (second != null){
            second = second.next
        }

        if (count == k){
            first = cur
            second = head
        }

        count++
        cur = cur.next
    }

    val temp = first!!.`val`
    first.`val` = second!!.`val`
    second.`val` = temp

    return head
}

var front:ListNode? = null
fun isPalindrome(head: ListNode?): Boolean {
    front = head
    try {
        return check(head)
    }catch (e:Exception){

    }
    return true
}
private fun check(cur:ListNode?):Boolean{
    if (cur != null){
        if (!check(cur.next))
            return false
        if (cur == front)
            throw RuntimeException("success")
        if (cur.`val` != front!!.`val`)
            return false
        front = front!!.next
    }
    return true
}

// 使用arrayqueue
fun isPalindrome1(head: ListNode?): Boolean {
    if (head?.next == null) return true
    var queue = ArrayDeque<ListNode>()
    var cur = head
    while (cur != null){
        queue.add(cur)
        cur = cur.next
    }

    while (queue.isNotEmpty()){
        if (queue.size>=2){
            if (queue.pollFirst().`val` != queue.pollLast().`val`) return false
        }else{
            break
        }
    }
    return true
}

fun main() {
//    var node1 = ListNode(1)
//    var node2 = ListNode(2)
//    var node3 = ListNode(3)
//    var node4 = ListNode(4)
//    var node5 = ListNode(5)
//
//    node1.next = node2
////    node2.next = node3
////    node3.next = node4
////    node4.next = node5
//    print(finMid(node1).`val`)
//    var T1= T(10,"haha")
//    var T2= T(10,"haha")
//    var list = mutableListOf<T>(T1,T2)
    add()
}

fun isPalindrome2(head: ListNode?): Boolean {
    if (head?.next == null) return true
    var mid = finMid(head)
    var tail:ListNode? = getReverse(mid)
    println(tail!!.`val`)
    var front = head
    while (tail != null){
        if (front!!.`val` != tail.`val`) return false
        tail = tail.next
        front = front!!.next
    }
    return true
}
private fun getReverse(mid:ListNode):ListNode{
    var cur:ListNode? = mid
    var pre:ListNode? = null
    while (cur != null){
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre!!
}

private fun finMid(head: ListNode?):ListNode{
    var first = head
    var second = head
    while (second?.next != null){
        first = first!!.next
        second = second.next!!.next
    }
    return first!!
}

fun add(){
    var array = doubleArrayOf(3.9,6.75,16.9,16.0, 49.0, 19.0, 6.57, 6.57, 4.99, 13.9, 39.0,9.0,13.0,16.0,12.42,50.43,34.11,19.9,17.89,14.85,35.0,6.87,6.87,14.1,19.0,4.45,40.9,58.0,48.0,19.8,19.8,26.61,24.8,90.9,4.32)
    var sum =0.0
    for (i in array){
        sum += i
    }
    print(sum)
}

fun search1(nums: IntArray, target: Int): Int {
    if(nums == null || nums.isEmpty() || target<nums[0] || target>nums.last()) return 0
    var head = 0
    var tail = nums.size-1
    while (head <= tail){
        if (nums[head] < target) head++
        if (nums[tail] > target) tail--
        if(nums[head] == target && nums[tail] == target) break
    }
    if (head > tail) return 0
    return tail-head + 1
}

fun ff(nums: IntArray, start:Int,end:Int,target: Int):Int{
    if(start>end) return -1
    val mid = start + (end - start) shr 1
    return when {
        nums[mid] > target -> ff(nums,start,mid-1,target)
        nums[mid] < target -> ff(nums,mid+1,end,target)
        else -> 1 + ff(nums,start,mid-1,target) + ff(nums,mid+1,end,target)
    }
}

fun quato(nums: IntArray,start:Int,end:Int):Int{
    if(start>end) return -1
    val mid = start + (end - start) shr 1
    var p = start
    var q = end
    val temp = nums[start]
    while (p < end){
        while (p < q && nums[q] >= temp) q--
        if(p < q) nums[p] = nums[q]
        while (p < q && nums[p] <= temp) p++
        if(p < q) nums[q] = nums[p]
    }
    nums[p] = temp
    return p
}



class T(var age:Int,var name:String){

}



