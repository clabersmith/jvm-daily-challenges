import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day14 {
    public static <E extends Comparable<E>> List<E> mergeSortedLists(List<E> list1, List<E> list2) {
        return usingStreams(list1, list2);
    }

    private static <E extends Comparable<E>> List<E> usingLoops(List<E> list1, List<E> list2) {
        List<E> mergedList = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;

        //we're only going to loop through each list once since both are already sorted, so in linear time
        while(i1 < list1.size() && i2 < list2.size()) {
            int compareVal = list1.get(i1).compareTo(list2.get(i2));
            if(compareVal <= 0) {
                //first list item is less or equal so use that
                mergedList.add(list1.get(i1));
                i1++;
            } else {
                //second list item is less so use that
                mergedList.add(list2.get(i2));
                i2++;
            }
        }

        //we're at the end of one or both lists so just merge any remaining
        if(i1 < list1.size()) {
            mergedList.addAll(list1.subList(i1, list1.size()));
        } else if(i2 < list2.size()) {
            mergedList.addAll(list2.subList(i2, list2.size()));
        }

        return mergedList;
    }

    private static <E extends Comparable<E>> List<E> usingStreams(List<E> list1, List<E> list2) {
        // Concatenate both streams and sort using natural order.
        // Note: O((n + m) log(n + m)) overall — N log N (superlinear), not logarithmic; linear merge is O(n + m).
        return Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());
    }
}
