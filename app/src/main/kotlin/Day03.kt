fun countVowels(s: String): Int =
    s.lowercase().count { c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' }
