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

    def "java: find the second largest for list of Integers"() {
        expect:
        Day15.findSecondLargest(list as List<Integer>) == expected

        where:
        list                      || expected
        [1, 2, 3, 4, 5]           || 4
        [5, 5, 4, 3]              || 4
        [10, 7]                   || 7
        [2, 2, 2]                 || null
        null                      || null
        [42]                      || null
        [5, 4, 5, 3]              || 4
        [-1, -2, -3]             || -2
        [1, null, 2]              || null
    }

    def "java: find the second largest for list of Floats"() {
        expect:
        Day15.findSecondLargest(list as List<Float>) == expected

        where:
        list                             || expected
        [1.0f, 2.0f, 3.0f, 4.0f, 5.0f]   || 4.0f
        [5.0f, 5.0f, 4.0f, 3.0f]         || 4.0f
        [10.0f, 7.0f]                    || 7.0f
        [2.0f, 2.0f, 2.0f]               || null
        null                             || null
        [42.0f]                          || null
        [5.0f, 4.0f, 5.0f, 3.0f]         || 4.0f
        [-1.0f, -2.0f, -3.0f]            || -2.0f
        [1.0f, null, 2.0f]               || null
    }

    def "kotlin: find the second largest for list of Integers"() {
            expect:
            Day15Kt.findSecondLargest(list as List<Integer>) == expected

            where:
            list                             || expected
            [3, 1, 2]                        || 2
            [0, 100, 50, 100]                || 50
            [-10, -5, -5, -20]               || -10
            [100]                            || null
            [null, 1, 2]                     || null
        }

    def "kotlin: find the second largest for list of Shorts"() {
        expect:
        Day15Kt.findSecondLargest(list as List<Short>) == expected

        where:
        list                                     || expected
        [3 as Short, 1 as Short, 2 as Short]     || 2 as Short
        [Short.MAX_VALUE, Short.MIN_VALUE, 123 as Short] || 123 as Short
        [7 as Short, 7 as Short, 6 as Short]     || 6 as Short
        [4 as Short, 4 as Short]                 || null
        null                                     || null
    }

    def "groovy: find the second largest for list of Integers"() {
        expect:
        Day15Groovy.findSecondLargest(list as List<Integer>) == expected

        where:
        list                    || expected
        [8, 3, 5, 8]            || 5
        [2, 2]                  || null
        null                    || null
        [10]                    || null
    }

    def "groovy: find the second largest for list of Doubles"() {
        expect:
        Day15Groovy.findSecondLargest(list as List<Double>) == expected

        where:
        list                                         || expected
        [1.0d, 3.5d, 2.2d, 3.5d]                     || 2.2d
        [5.0d, 5.0d]                                 || null
        null                                         || null
        [7.7d]                                       || null
    }

}
