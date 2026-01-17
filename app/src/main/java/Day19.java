import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day19 {
    public static <T> Map<T, Integer> countDistinct(List<T> list) {
        return usingStreams(list);
    }

    private static <T> Map<T, Integer> usingLoops(List<T> list) {
        Map<T, Integer> countMap = new HashMap<>();

        for(T item : list) {
            //add the item to map if not there
            Integer currCnt = countMap.putIfAbsent(item, 1);

            //if we got a value instead, update it
            if(currCnt != null) {
                countMap.put(item, currCnt + 1);
            }
        }

        return countMap;
    }

    private static <T> Map<T, Integer> usingStreams(List<T> list) {
        return list.stream()
                   .collect(Collectors.toMap(
                       item -> item,
                       item -> 1,
                       Integer::sum
                   ));
    }
}
