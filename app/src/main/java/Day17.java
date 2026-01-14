import java.util.List;
import java.util.stream.IntStream;

public class Day17 {

    /**
     * Returns true if the given list is null, has fewer than two elements, or is sorted in
     * non-decreasing order.
     *
     * @param list the list to check
     * @param <E> element type, must be comparable
     * @return true if the list is sorted (non-decreasing), false otherwise
     */
    public static <E extends Comparable<E>> boolean isSorted(List<E> list) {
        if (list == null || list.size() < 2) return true;

        return usingLoops(list);
    }

    private static <E extends Comparable<? super E>> boolean usingLoops(List<E> list) {
        E previous = null;

        for(E item : list) {
            if(previous != null && item.compareTo(previous) < 0) {
                return false;
            }
            previous = item;
        }

        return true;
    }

    private static <E extends Comparable<? super E>> boolean usingStreams(List<E> list) {
        return IntStream.range(1, list.size())
                .allMatch(i -> list.get(i - 1).compareTo(list.get(i)) <= 0);
    }
}
