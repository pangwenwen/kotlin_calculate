package trie

fun main() {
    var world = WordDictionary()
    world.addWord("at")
    world.addWord("and")
    world.addWord("an")
    world.addWord("add")
//    println(world.search("a"))
//    println(world.search(".at"))
    world.addWord("bat")
//    println(world.search(".at"))
//    println(world.search("an."))
//    println(world.search("a.d."))
//    println(world.search("b."))
    println(world.search("a.d"))
//    println(world.search("."))

}

class WordDictionary {
    class Node{
        var charItem = mutableMapOf<Char,Node>()
        var isEnd = false
    }
    /** Initialize your data structure here. */
    val root = Node()

    fun addWord(word: String) {
        var cur = root
        for(i in word){
            if (!cur.charItem.containsKey(i)){
                cur.charItem[i] = Node()
            }
            cur = cur.charItem[i]!!
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        tag = false // 需要进行恢复
        searchItem(word,0,root)
        return tag
    }

    var tag = true
    private fun searchItem(world: String, index:Int, node:Node){
        if (index >= world.length){
            tag = node.isEnd
            return
        }
        var i = index
        val char = world[i]
        if (char == '.'){
            if (node.charItem.isEmpty()){
                tag = false
                return
            }
            else{
                val item = node.charItem
                for((key,value) in item){
                    if (tag) return  // 只要找到一个不必再遍历了
                    searchItem(world,++i,node.charItem[key]!!)
                    i = index // 没有找到需要回复i 到"."位置的index
                }
            }
        }else{
            if (!node.charItem.containsKey(char)){
                tag = false
                return
            }
            else searchItem(world,++i,node.charItem[char]!!)
        }
    }

}