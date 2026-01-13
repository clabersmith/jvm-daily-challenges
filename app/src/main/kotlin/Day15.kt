fun <E : Comparable<E>> findSecondLargest(list: List<E?>?): E?  {
    if (list == null || list.any { it == null } || list.size < 2) {
        return null
    }

    return list
        .filterNotNull()
        .distinct()
        .sortedDescending()
        .getOrNull(1)
}
