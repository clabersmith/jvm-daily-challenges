import java.util.List;
import java.util.Objects;

public class Day15 {
    public static <E extends Comparable<E>> E findSecondLargest(List<E> list) {
        if(list == null || list.contains(null) || list.size() < 2) {
            return null;
        }

        return usingLoops(list);
    }

    private static <E extends Comparable<E>> E usingLoops(List<E> list) {
        E largest = null;
        E second = null;

        for (E item : list) {
            if (largest == null || item.compareTo(largest) > 0) {
                second = largest;
                largest = item;
            } else if (item.compareTo(largest) < 0) {
                if (second == null || item.compareTo(second) > 0) {
                    second = item;
                }
            }
        }

        return second; //returns as null if list contains only duplicates
    }

    private static <E extends Comparable<E>> E usingStreams(List<E> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(java.util.Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}
