class Day18Groovy {
    static <T> T[] rotateArray(T[] array, int n) {
        if (array == null) throw new IllegalArgumentException("array must not be null")
        int len = array.length
        if (len < 2) return Arrays.copyOf(array, len)

        def list = array.toList()
        Collections.rotate(list, n) // use JDK rotate

        list.toArray(Arrays.copyOf(array, 0))
    }
}
