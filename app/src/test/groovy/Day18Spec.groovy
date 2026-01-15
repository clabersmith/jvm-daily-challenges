import spock.lang.Specification
import support.Person

/**
 * Problem:
 * Rotate an array by N positions.
 *
 * Description:
 * Given an array of elements and an integer N, write a function that rotates
 * the array by N positions. A rotation shifts elements to the left or right
 * while preserving their relative order.
 *
 * The direction of rotation and how values of N larger than the array length
 * are handled should be clearly defined and documented.
 *
 * Constraints:
 * - The input array must not be null.
 * - The solution should return a new array
 * - The array may be empty or contain a single element.
 * - The rotation count N may be positive, zero, or negative.
 *
 * Examples:
 * - Input: [1, 2, 3, 4, 5], N = 2 (right rotation)
 *   Output: [4, 5, 1, 2, 3]
 *
 * - Input: [1, 2, 3, 4, 5], N = -1 (left rotation)
 *   Output: [2, 3, 4, 5, 1]
 *
 * - Input: ["a", "b", "c"], N = 3
 *   Output: ["a", "b", "c"]
 */
class Day18Spec extends Specification {

    def "java: rotate array of Integers"() {
        expect:
        Day18.rotateArray(array as Integer[], n) == expected

        where:
        array                      | n                          || expected
        [1, 2, 3, 4, 5]            | 2                          || [4, 5, 1, 2, 3] as Integer[]
        [1, 2, 3, 4, 5]            | -1                         || [2, 3, 4, 5, 1] as Integer[]
        [1, 2, 3, 4, 5]            | 5                          || [1, 2, 3, 4, 5] as Integer[]
        [1, 2, 3, 4, 5]            | 7                          || [4, 5, 1, 2, 3] as Integer[]
        []                         | 3                          || [] as Integer[]
        [42]                       | 10                         || [42] as Integer[]
        [1, 2, 2, 3]               | 2                          || [2, 3, 1, 2] as Integer[]
        [1, 2]                     | 1                          || [2, 1] as Integer[]
    }

    def "java: rotate array of Strings"() {
        expect:
        Day18.rotateArray(array as String[], n) == expected

        where:
        array                        | n                        || expected
        ["a", "b", "c"]              | 3                        || ["a", "b", "c"] as String[]
        ["x", "y", "z", "w"]         | -1                       || ["y", "z", "w", "x"] as String[]
        ["a", "b", "c"]              | 2                        || ["b", "c", "a"] as String[]
        []                           | 1                        || [] as String[]
        ["a", "b", "a", "c"]         | -2                       || ["a", "c", "a", "b"] as String[]
    }

    def "java: rotate array of Person"() {
        expect:
        Day18.rotateArray(array as Person[], n) == expected

        where:
        array                                                                                               | n         || expected
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Carol", 40)]                           | 1         || [new Person("Carol", 40), new Person("Alice", 30), new Person("Bob", 25)] as Person[]
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Bob", 55)]                             | 2         || [new Person("Bob", 25), new Person("Bob", 55), new Person("Alice", 30)] as Person[]
        [new Person("Dave", 20), new Person("Eve", 22), new Person("Frank", 24), new Person("Grace", 26)]   | 3         || [new Person("Eve", 22), new Person("Frank", 24), new Person("Grace", 26), new Person("Dave", 20)] as Person[]
        [new Person("Hank", 50), new Person("Ivy", 55), new Person("Jack", 60)]                             | -1        || [new Person("Ivy", 55), new Person("Jack", 60), new Person("Hank", 50)] as Person[]
    }

    def "kotlin: rotate array of Integers"() {
        expect:
        Day18Kt.rotate(array as Integer[], n) == expected

        where:
        array                    | n                            || expected
        [10, 20, 30, 40, 50]     | 3                            || [30, 40, 50, 10, 20] as Integer[]
        [5, 6, 7, 8, 9]          | -2                           || [7, 8, 9, 5, 6] as Integer[]
        [2, 4, 6, 8]             | 4                            || [2, 4, 6, 8] as Integer[]
        [0]                      | -5                           || [0] as Integer[]
        [3, 3, 3, 3]             | 1                            || [3, 3, 3, 3] as Integer[]
        [9, 8, 7]                | 5                            || [8, 7, 9] as Integer[]
        [1, 2, 3, 4]             | -3                           || [4, 1, 2, 3] as Integer[]
        [7, 7, 8, 9]             | 2                            || [8, 9, 7, 7] as Integer[]
    }

    def "groovy: rotate array of Strings using Day18Groovy"() {
        expect:
        Day18Groovy.rotateArray(array as String[], n) == expected

        where:
        array                        | n                        || expected
        ["a", "b", "c"]              | 3                        || ["a", "b", "c"] as String[]
        ["x", "y", "z", "w"]         | -1                       || ["y", "z", "w", "x"] as String[]
        ["a", "b", "c"]              | 2                        || ["b", "c", "a"] as String[]
        []                           | 1                        || [] as String[]
        ["a", "b", "a", "c"]         | -2                       || ["a", "c", "a", "b"] as String[]
    }

}
