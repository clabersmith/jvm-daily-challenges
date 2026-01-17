class Day19Groovy {
    static <T> Map<T, Integer> countDistinct(List<T> list) {
        list.countBy { it }
    }
}
