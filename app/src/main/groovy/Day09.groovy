class Day09Groovy {
    static String capitalizeFirst(String input) {
        input.trim()
            .tokenize()
            .collect { it.capitalize() }
            .join(' ')
    }
}