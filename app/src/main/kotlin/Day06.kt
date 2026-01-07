fun isAnagrams(s1: String, s2: String) : Boolean =
    s1.lowercase().filterNot { it.isWhitespace() }.groupingBy { it }.eachCount() ==
            s2.lowercase().filterNot { it.isWhitespace() }.groupingBy { it }.eachCount()