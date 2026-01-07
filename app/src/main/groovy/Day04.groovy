class Day04Groovy {
    static String removeDuplicates(String s) {
        return s.toList().unique().join()  //toSet doesn't preserve order in Groovy
    }
}
