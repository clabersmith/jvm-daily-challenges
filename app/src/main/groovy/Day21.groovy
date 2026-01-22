class Day21Groovy {
    static <T extends Comparable> int binarySearchSortedList(List<T> list, T item) {
        if (!list) return -1

        int s = 0, e = list.size()

        while (s < e) {
            int mid = (s + e) >>> 1
            int cmp = item.compareTo(list[mid])
            if (cmp == 0) return mid
            if (cmp < 0) e = mid else s = mid + 1
        }

        return -1
    }
}