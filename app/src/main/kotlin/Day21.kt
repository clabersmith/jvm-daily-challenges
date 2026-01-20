fun <T : Comparable<T>> binarySearchSortedList(list: List<T>?, item: T): Int {
    if (list.isNullOrEmpty()) return -1

    var low = 0
    var high = list.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        val cmp = item.compareTo(list[mid])
        when {
            cmp == 0 -> return mid
            cmp < 0 -> high = mid - 1
            else -> low = mid + 1
        }
    }

    return -1
}