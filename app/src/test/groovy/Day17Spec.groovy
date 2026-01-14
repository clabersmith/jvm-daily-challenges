import spock.lang.Specification
import support.Person

/**
 * Problem:
 * Determine if a list is sorted.
 *
 * Description:
 * Given a list of elements, write a function that determines whether the list
 * is sorted according to the natural ordering of its elements. The list is
 * considered sorted if each element is less than or equal to the element that
 * follows it.
 *
 * The function should work for lists of arbitrary length, including empty
 * lists and single-element lists.
 *
 * Constraints:
 * - The input list must not be null.
 * - All elements in the list must be mutually comparable.
 * - The list may contain duplicate values.
 *
 * Examples:
 * - Input: [1, 2, 3, 4, 5]
 *   Output: true
 *
 * - Input: [1, 2, 2, 3]
 *   Output: true
 *
 * - Input: [5, 3, 1]
 *   Output: false
 *
 * - Input: ["a", "b", "a"]
 *   Output: false
 */
class Day17Spec extends Specification {

    def "java: test if list of Integers are sorted"() {
        expect:
        Day17.isSorted(list) == expected

        where:
        list                        || expected
        []                          || true
        [42]                        || true
        [-3, -1, 0, 2]              || true
        [2, 2, 2]                   || true
        [1, 3, 2, 4]                || false
        [1, 2, 3, 0]                || false
        [5, 4, 3, 2, 1]             || false
    }

    def "java: test if list of Persons are sorted"() {
        expect:
        Day17.isSorted(list1) == expected

        where:
        list1                                                                               || expected
        null                                                                                || true
        []                                                                                  || true
        [new Person("Alice", 30)]                                                           || true
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 20)]         || true
        [new Person("Alice", 20), new Person("Alice", 30)]                                  || true
        [new Person("Charlie", 35), new Person("Charlie", 30)]                              || false
        [new Person("Bob", 40), new Person("Alice", 25)]                                    || false
        [new Person("Alice", 20), new Person("Charlie", 25), new Person("Bob", 30)]         || false
    }

    def "kotlin: test if list of Longs are sorted"() {
        expect:
        Day17Kt.isSorted(list) == expected

        where:
        list                        || expected
        []                          || true
        null                        || true
        [42L]                       || true
        [-3L, -1L, 0L, 2L]          || true
        [2L, 2L, 2L]                || true
        [1L, 3L, 2L, 4L]            || false
        [1L, 2L, 3L, 0L]            || false
        [5L, 4L, 3L, 2L, 1L]        || false
    }

    def "kotlin: test if list of Strings are sorted"() {
        expect:
        Day17Kt.isSorted(list) == expected

        where:
        list                            || expected
        []                              || true
        ["a"]                           || true
        ["a", "b", "c", "d"]            || true
        ["a", "b", "b", "c"]            || true
        ["a", "c", "b", "d"]            || false
        ["z", "y", "x"]                 || false
        ["apple", "banana", "apple"]    || false
    }

    def "groovy: test if list of BigDecimals are sorted"() {
        expect:
        Day17Groovy.isSorted(list) == expected

        where:
        list                                                                                                        || expected
        []                                                                                                          || true
        [new BigDecimal("42")]                                                                                      || true
        [new BigDecimal("-3"), new BigDecimal("-1"), new BigDecimal("0"), new BigDecimal("2")]                      || true
        [new BigDecimal("2"), new BigDecimal("2"), new BigDecimal("2")]                                             || true
        [new BigDecimal("1"), new BigDecimal("3"), new BigDecimal("2"), new BigDecimal("4")]                        || false
        [new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("0")]                        || false
        [new BigDecimal("5"), new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("2"), new BigDecimal("1")]   || false
    }

    def "groovy: test if list of Strings are sorted"() {
        expect:
        Day17Groovy.isSorted(list) == expected

        where:
        list                            || expected
        []                              || true
        null                            || true
        ["a"]                           || true
        ["a", "b", "c", "d"]            || true
        ["a", "b", "b", "c"]            || true
        ["a", "c", "b", "d"]            || false
        ["z", "y", "x"]                 || false
        ["apple", "banana", "apple"]    || false
    }

}