class Day14Groovy {
    static <E> List<E> mergeSortedLists(List<E> list1, List<E> list2) {
        (list1 + list2).sort()
    }
}
