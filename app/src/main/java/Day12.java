import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Day12 {
    public static BigDecimal findAverage(List<Integer> list) {
        return usingLoops(list);
    }

    private static BigDecimal usingLoops(List<Integer> list) {
        BigDecimal sum = BigDecimal.ZERO;

        for(int val : list) {
            sum = sum.add(BigDecimal.valueOf(val));
        }

        return sum.divide(BigDecimal.valueOf(list.size()), 15,
                RoundingMode.HALF_UP);
    }

    private static BigDecimal usingStreams(List<Integer> list) {
        BigDecimal sum = list.stream()
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.divide(BigDecimal.valueOf(list.size()), 15,
                RoundingMode.HALF_UP);
    }
}
