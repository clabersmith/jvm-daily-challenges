import java.util.List;

public class Day21 {

    public static <E extends Comparable<E>> int binarySearchSortedList(List<E> list, E item) {
        if(list == null || list.isEmpty()) {
            return -1;
        }

        //using collections api
        //return Collections.binarySearch(list, item);

        return usingLoops(list, item, 0, list.size());
    }

    private static <E extends Comparable<E>> int usingRecursion(List<E> list, E item, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        E midItem = list.get(mid);
        int compareVal = item.compareTo(midItem);

        if (compareVal == 0) {
            return mid;
        } else if (compareVal < 0) {
            return usingRecursion(list, item, start, mid);
        } else {
            return usingRecursion(list, item, mid + 1, end);
        }
    }

    private static <E extends Comparable<E>> int usingLoops(List<E> list, E item, int start, int end) {
        int s = start;
        int e = end;
        while (s < e) {
            int mid = s + (e - s) / 2;
            E midItem = list.get(mid);
            int compareVal = item.compareTo(midItem);
            if (compareVal == 0) {
                return mid;
            } else if (compareVal < 0) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
