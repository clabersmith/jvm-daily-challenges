class Day10Groovy {
    static boolean isUniqueCharacters(String input) {
        input.toSet().size() == input.length()
    }
}