import java.math.BigDecimal

fun findAverage(list : List<Int>) : BigDecimal?  {
    val sum = list.fold(BigDecimal.ZERO) { acc, v -> acc + BigDecimal.valueOf(v.toLong()) }

    return sum.divide(BigDecimal.valueOf(list.size.toLong()), 15,
        java.math.RoundingMode.HALF_UP)
}
