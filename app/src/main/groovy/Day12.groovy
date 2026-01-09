import java.math.RoundingMode

class Day12Groovy {
    static BigDecimal findAverage(List<Integer> list) {
        BigDecimal sum = list.inject(BigDecimal.ZERO) { acc, val -> acc + val }

        return sum.divide(new BigDecimal(list.size()), 15,
                RoundingMode.HALF_UP)
    }
}
