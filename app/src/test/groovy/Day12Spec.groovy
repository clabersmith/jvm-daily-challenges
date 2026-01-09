import spock.lang.Specification

/**
 * Problem:
 * Compute the average of a list of integers.
 *
 * Rules and Constraints:
 * - The list will contain at least one integer.
 * - The list may contain positive and negative numbers.
 * - The average should be computed using floating-point division.
 * - The result should represent the mathematical mean of all values.
 *
 * Examples:
 * - [1, 2, 3, 4, 5]   → 3.0
 * - [10, -10, 20]    → 6.6667 (approx.)
 * - [7]              → 7.0
 */
class Day12Spec extends Specification {
    def "java: find the average of a list of integers"() {
        expect:
        Day12.findAverage(input) == expected

        where:
        input               || expected
        [1, 2, 3, 4, 5]     || 3.0
        [10, -10, 20]       || 6.666666666666667
        [7]                 || 7.0
        [1, 2]              || 1.5
        [-1, -2, 2]         || -0.333333333333333
    }

    def "kotlin: findAverage works with different inputs"() {
        expect:
        Day12Kt.findAverage(input) == expected

        where:
        input                  || expected
        [0, 0, 0]              || 0.0
        [5, 5, 5, 5]           || 5.0
        [-5, 5]                || 0.0
        [100, 200, 300, 400]   || 250.0
        [-3, -3, -3]           || -3.0
        [1, 0, 0, 0, 0, 0, 0]  || 0.142857142857143
    }

    def "groovy: findAverage for Day12.groovy implementation"() {
            expect:
            Day12Groovy.findAverage(input) == expected

            where:
            input                 || expected
            [2, 4, 6]             || 4.0
            [3, 0, -3]            || 0.0
            [1, 1, 1, 2]          || 1.25
            [1, 2, 2]             || 1.666666666666667
            [9, -3]               || 3.0
            [1000, 2000]          || 1500.0
        }
}
