import java.util.List;
import java.util.Optional;

public class Day11 {
    public static Integer findMax(List<Integer> list) {
        return usingStream(list);
    }

    private static Integer usingLoop(List<Integer> list) {
        Integer maxVal = null;

        for(int i : list) {
            if(maxVal == null || i > maxVal) {
                maxVal = i;
            }
        }

        return maxVal;
    }

    private static Integer usingStream(List<Integer> list) {
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        return max.orElse(null);
    }
}
