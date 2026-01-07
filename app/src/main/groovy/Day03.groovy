class Day03Groovy {
    static long countVowels(String s) {
        return s.findAll(/(?i)[aeiou]/).size()  //case insensitive vowel match
    }
}
