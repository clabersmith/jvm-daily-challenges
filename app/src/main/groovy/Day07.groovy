class Day07Groovy {
    // Groovy-style run-length encoding using inject, closures, and tuple grouping
    // Similar to fold and Pair example in Kotlin solution
    static String compress(String s) {
        return s.inject([]) { acc, c ->
            if (acc.isEmpty() || acc[-1][0] != c)
                acc << new Tuple2(c, 1)
            else
                acc[-1] = new Tuple2(c, acc[-1][1] + 1)
            acc
        }.collect { it[0] + it[1].toString() }.join('')
    }
}