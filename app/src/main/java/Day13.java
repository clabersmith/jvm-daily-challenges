import java.util.*;
import java.util.stream.Collectors;

public class Day13 {
    public static <E> List<E> removeValueFromList(E value, List<E> list) {
        return usingLoops(value, list);
    }

    private static <E> List<E> usingLoops(E value, List<E> list) {
        List<E> revList = new ArrayList<>();
        for(E e : list) {
            if(!Objects.equals(e, value)) { //null safe
                revList.add(e);
            }
        }

        return revList;
    }

    private static <E> List<E> usingStreams(E value, List<E> list) {
        return list.stream().filter(it -> !Objects.equals(it,value)).collect(Collectors.toList());
    }
}
