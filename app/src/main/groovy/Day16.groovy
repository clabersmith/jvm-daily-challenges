class Day16Groovy {
    static <E extends Comparable> List<E> findIntersection(List<E> list1, List<E> list2) {
        if (list1 == null || list2 == null) return [] as List<E>
        return list1.intersect(list2).unique().sort()
    }
}