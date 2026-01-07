fun isPalindrome2(s: String): Boolean {
    val s2 = StringBuilder()
    for(i in s.length-1 downTo 0) {
        s2.append(s[i])
    }

    return s == s2.toString()
} 