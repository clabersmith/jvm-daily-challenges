import spock.lang.Specification

/**
 * Problem:
 * Return the second largest number in a list.
 *
 * Description:
 * Given a list of numeric values, write a function that returns the second
 * largest distinct number in the list. The list may contain duplicate values,
 * and the second largest value must be strictly less than the maximum value.
 *
 * The function should handle lists of arbitrary length and should define
 * clear behavior for invalid inputs, such as lists with fewer than two
 * distinct elements.
 *
 * Constraints:
 * - The input list must not be null.
 * - The list must contain at least two values.
 * - Duplicate values are allowed but should not affect the result.
 *
 * Examples:
 * - Input: [1, 2, 3, 4, 5]
 *   Output: 4
 *
 * - Input: [5, 5, 4, 3]
 *   Output: 4
 *
 * - Input: [10, 7]
 *   Output: 7
 *
 * - Input: [2, 2, 2]
 *   Output: (invalid — no second largest distinct value)
 */
class Day15Spec extends Specification {

    private static Object findSecondLargest(String impl, List list) {
        switch(impl) {
            case 'java':   return Day15.findSecondLargest(list)
            case 'kotlin': return Day15Kt.findSecondLargest(list)
            case 'groovy': return Day15Groovy.findSecondLargest(list)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: find the second largest for list of Integers"() {
        expect:
        findSecondLargest(impl as String, list as List<Integer>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list                    || expected
                        [[1, 2, 3, 4, 5],           4],
                        [[5, 5, 4, 3],              4],
                        [[10, 7],                   7],
                        [[2, 2, 2],                 null],
                        [null,                      null],
                        [[42],                      null],
                        [[5, 4, 5, 3],              4],
                        [[-1, -2, -3],             -2],
                        [[1, null, 2],              null]
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }

    def "#impl: find the second largest for list of Floats"() {
        expect:
        findSecondLargest(impl as String, list as List<Float>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list                           || expected
                        [[1.0f, 2.0f, 3.0f, 4.0f, 5.0f],   4.0f],
                        [[5.0f, 5.0f, 4.0f, 3.0f],         4.0f],
                        [[10.0f, 7.0f],                    7.0f],
                        [[2.0f, 2.0f, 2.0f],               null],
                        [null,                             null],
                        [[42.0f],                          null],
                        [[5.0f, 4.0f, 5.0f, 3.0f],         4.0f],
                        [[-1.0f, -2.0f, -3.0f],            -2.0f],
                        [[1.0f, null, 2.0f],               null]
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }

    def "#impl: find the second largest for list of Shorts"() {
        expect:
        findSecondLargest(impl as String, list as List<Short>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list                                            || expected
                        [[3 as Short, 1 as Short, 2 as Short],             2 as Short],
                        [[Short.MAX_VALUE, Short.MIN_VALUE, 123 as Short], 123 as Short],
                        [[7 as Short, 7 as Short, 6 as Short],             6 as Short],
                        [[4 as Short, 4 as Short],                         null],
                        [null,                                             null]
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }
}
