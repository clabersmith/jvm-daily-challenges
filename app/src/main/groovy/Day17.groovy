class Day17Groovy {

    private static <E extends Comparable<? super E>> boolean isSorted(List<E> list) {
        if(list == null || list.size() < 2) return true

        (1..<list.size()).every { i -> (list[i - 1] <= list[i]) }
    }
}
