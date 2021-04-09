package stringOp

import java.util.*

fun main() {
    lengthOfLongestSubstring("abcabcbb")
}

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    if (s.length == 1|| s.trim().isEmpty()) return 1
    // 1. 构造数组
    var array = ArrayDeque<Char>()

    var len = 0
    var p = 0
    var q = 0
    val strL = s.length
    while (q < strL && (strL-p)>len){
        if (p == q || !array.contains(s[q])){
            array.add(s[q++])
            continue
        }

        if (array.contains(s[q])){
            if (q-p > len) len = q-p
            while (s[p] != s[q]){
                p++
                array.pop()
            }
            p++
            array.pop()
        }
    }
    if((q-p) > len) len = q-p
    return len
}