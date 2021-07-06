package mapsum

// https://leetcode-cn.com/problems/map-sum-pairs/

class MapSum() {
    /** Initialize your data structure here. */
    var data = mutableMapOf<String,Int>()

    fun insert(key: String, `val`: Int) {
        data[key] = `val`
    }

    fun sum(prefix: String): Int {
        var result = 0
        for ((key,value) in data){
            if (key.startsWith(prefix)) result+= value
        }
        return 0

    }
}

// 通过字典树
class MapSum2() {
    /** Initialize your data structure here. */
    class Node{
        var next = mutableMapOf<Char,Node>()
        var value = 0
    }

    var root = Node()

    fun insert(key: String, `val`: Int) {
        var cur = root
        for (i in key){
            if (!cur.next.containsKey(i)) cur.next[i] = Node()
            cur = cur.next[i]!!
        }
        cur.value = `val`
    }

    fun sum(prefix: String): Int {
        var cur = root
        var sum = 0
        for (i in prefix){
            if (!cur.next.containsKey(i)) return 0
            cur = cur.next[i]!!
        }

        return sum(cur)
    }

    fun sum(node:Node):Int{
        var res = node.value
        for ((key,value) in node.next){
            res += sum(value)
        }
        return res
    }

}