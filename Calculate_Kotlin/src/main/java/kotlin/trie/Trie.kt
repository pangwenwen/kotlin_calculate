package trie

import javax.xml.stream.events.Characters

class Trie(){

    class Node{
        var next = mutableMapOf<Char,Node>()
        var isWorld = false
    }


    /** Initialize your data structure here. */
    var root = Node()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var cur = root
        for (i in word){
            if (!cur.next.containsKey(i)){
                cur.next[i] = Node()
            }
            cur = cur.next.get(i)!!
        }
        cur.isWorld = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var cur = root
        for (i in word){
            if (!cur.next.containsKey(i)) return false
            cur = cur.next.get(i)!!
        }
        return cur.isWorld
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var cur = root
        for (i in prefix){
            if (!cur.next.containsKey(i)) return false
            cur = cur.next.get(i)!!
        }
        return true
    }
}