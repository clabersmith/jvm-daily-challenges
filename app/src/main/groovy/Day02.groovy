class Day02Groovy {
    static boolean isPalindrome(String s) {
        def s1 = ""
        for(i in s.length()-1..0) {
            s1 += s[i]
        }
        return s1 == s
    }
}
