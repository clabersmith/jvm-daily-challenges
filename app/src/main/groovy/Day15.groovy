class Day15Groovy {
    static <E extends Comparable> E findSecondLargest(List<E> list) {
        if (!list || list.any { it == null } || list.size() < 2) return null

        def uniq = list.findAll { it != null }.unique().sort() // ascending
        return uniq.size() >= 2 ? uniq[-2] : null
    }
}
