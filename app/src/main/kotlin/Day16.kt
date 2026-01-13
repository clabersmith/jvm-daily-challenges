fun <E : Comparable<E>> findIntersection(list1: List<E>?, list2: List<E>?): List<E> {
    if(list1 == null || list2 == null) return emptyList();

    return list1.toSortedSet().apply { retainAll(list2) }.toList()
}