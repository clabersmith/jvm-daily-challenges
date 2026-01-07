class Day05Groovy {
    static String getFirstNonRepeatingChar(String s) {
        usingMapAndFind(s)
    }

    private static String usingLoops(String s) {
        for (char c in s.toCharArray()) {
            def ss = String.valueOf(c)
            if (s.indexOf(ss) == s.lastIndexOf(ss)) {
                return ss
            }
        }

        return ""
    }

    private static String usingMapAndFind(String s) {
        // Uses Groovy collection methods and closures to create a map of char to counts
        return s.toList()
                .countBy {it}
                .find {it.value == 1}?.key ?: ''
    }
}
