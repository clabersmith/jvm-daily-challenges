fun <T> countDistinct(list: List<T>): Map<T, Int> =
    list.groupingBy { it }.eachCount()