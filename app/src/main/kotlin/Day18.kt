/**
 * Extension function that returns a new array with elements rotated by [n] positions to the right.
 *
 * Negative [n] rotates to the left.
 *
 * @receiver the array to rotate
 * @param n number of positions to rotate; may be negative or larger than the array size
 * @return a new array containing the rotated elements
 */
fun <T> Array<T>?.rotate(n: Int): Array<T> {
    val arr = this ?: throw IllegalArgumentException("array must not be null")
    if (arr.size < 2) return arr.copyOf()
    val shift = ((n % arr.size) + arr.size) % arr.size
    return arr.copyOfRange(arr.size - shift, arr.size) + arr.copyOfRange(0, arr.size - shift)
}