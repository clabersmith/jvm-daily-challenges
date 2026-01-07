class Day11Groovy {
    static Integer findMax(List<Integer> numbers) {
        //max throws NoSuchElement exception so check first
        if (numbers == null || numbers.isEmpty()) {
            return null
        }

        return numbers.max()
    }
}
