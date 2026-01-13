import java.util.*;

public class Day16 {

    /**
     * Returns the intersection of two input lists as a new sorted list.
     * The returned list contains only unique elements present in both lists,
     * ordered according to the natural ascending order defined by E::compareTo.
     *
     * @param list1 the first input list
     * @param list2 the second input list
     * @param <E> element type, must implement Comparable
     * @return a new List containing the intersection in ascending natural order
     */
    public static <E extends Comparable<E>> List<E> findIntersection(List<E> list1, List<E> list2) {
        if(list1 == null || list2 == null) {
            return Collections.emptyList();
        }

        return usingStreams(list1, list2);
    }

    private static <E extends Comparable<E>> List<E> usingLoops(List<E> list1, List<E> list2) {
        SortedSet<E> intersectSet= new TreeSet<>();

        HashMap<E, E> list1Hash = new HashMap<>();
        for(E item : list1) {
            list1Hash.put(item, item);
        }

        for(E item : list2) {
            if(list1Hash.containsKey(item)) {
                intersectSet.add(item);
            }
        }

        return new ArrayList<>(intersectSet);
    }

    private static <E extends Comparable<E>> List<E> usingCollections(List<E> list1, List<E> list2) {
        Set<E> setForList2 = new HashSet<>(list2);
        Set<E> intersectSet = new TreeSet<>(list1);

        intersectSet.retainAll(setForList2);

        return new ArrayList<>(intersectSet);
    }

    private static <E extends Comparable<E>> List<E> usingStreams(List<E> list1, List<E> list2) {
        Set<E> setForList2 = new HashSet<>(list2);
        return list1.stream()
                .filter(setForList2::contains)
                .distinct()
                .sorted()
                .collect(java.util.stream.Collectors.toList());
    }
}
