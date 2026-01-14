fun <T : Comparable<T>> isSorted(list : List<T>?): Boolean =
    list?.zipWithNext()?.all { (a, b) -> a <= b } ?: true