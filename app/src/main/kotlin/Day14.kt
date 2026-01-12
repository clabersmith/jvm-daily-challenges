fun <E : Comparable<E>> mergeSortedLists(list1: List<E>, list2: List<E>) : List<E> {
    return (list1 + list2).sorted()
}