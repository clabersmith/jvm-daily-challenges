class Day20Groovy {
    static String getLongestWord(String sentence) {
        sentence?.tokenize()?.max { it.length() } ?: ""
    }
}
