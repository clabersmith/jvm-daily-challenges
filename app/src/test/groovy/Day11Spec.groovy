import spock.lang.Specification

/**
 * Problem:
 * Find the maximum number in a given list of integers.
 *
 * Rules and Constraints:
 * - The list can be empty but otherwise will contain integers
 * - The list may contain negative numbers.
 * - The list may contain duplicate values.
 * - The order of elements in the list is arbitrary.
 *
 * Examples:
 * - [1, 3, 2, 5, 4] → 5
 * - [-10, -3, -20] → -3
 * - [7]            → 7
 * - [2, 2, 2]      → 2
 */
class Day11Spec extends Specification {

    def "java: find maximum number in a list"() {
        expect:
        Day11.findMax(input) == expected

        where:
        input               || expected
        [1, 3, 2, 5, 4]     || 5
        [-7, -3, -10, -1]   || -1
        [2, 2, 2, 2]        || 2
        [0, -1, 5, 5, 3]    || 5
        []                  || null
    }

    def "kotlin: find maximum number in a list"() {
        expect:
        Day11Kt.findMax(input) == expected

        where:
        input                   || expected
        [10, 20, 30, 40]        || 40
        [-100, -50, -200, -5]   || -5
        [7, 7, 7]               || 7
        [0, 1, 2, 3, 2, 1, 0]   || 3
        []                      || null
    }

    def "groovy: find maximum number in a list"() {
        expect:
        Day11Groovy.findMax(input) == expected

        where:
        input                   || expected
        [5, 8, 2, 9, 3]         || 9
        [-4, -2, -8, -6]        || -2
        [0, 0, 0, 0]            || 0
        [100, 50, 100, 99]      || 100
        []                      || null
    }

}
