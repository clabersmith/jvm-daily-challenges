import spock.lang.Specification
import spock.lang.Unroll
import support.Person

/**
 * Problem:
 * Find the intersection of two lists.
 *
 * Description:
 * Given two lists of elements, write a function that returns a new list
 * containing the elements that appear in both input lists. The intersection
 * should include each common element only once, regardless of how many times
 * it appears in the input lists.
 *
 * The order of elements in the result should be well-defined and documented,
 * such as preserving the order of the first list or returning elements in
 * natural sorted order.
 *
 * Constraints:
 * - Neither input list may be null.
 * - The lists may be of different lengths.
 * - Duplicate values may appear in the input lists.
 * - The result must not contain duplicate elements.
 *
 * Examples:
 * - Input: [1, 2, 3, 4], [3, 4, 5, 6]
 *   Output: [3, 4]
 *
 * - Input: ["a", "b", "c"], ["b", "c", "d"]
 *   Output: ["b", "c"]
 *
 * - Input: [1, 2, 2, 3], [2, 3, 3]
 *   Output: [2, 3]
 */
class Day16Spec extends Specification {

    def "java: find intersection of two lists of Integers"() {
        expect:
        Day16.findIntersection(list1, list2) == expected

        where:
        list1                      | list2                      || expected
        [4, 1, 2, 3, 2, 5]         | [3, 2, 6, 2, 4]            || [2, 3, 4]
        []                         | []                         || []
        [1, 1, 1]                  | [1]                        || [1]
        [3, 2, 1]                  | [4, 5, 6]                  || []
        [5, 4, 3, 3, 2]            | [2, 3, 3, 7]               || [2, 3]
        [2, 2, 2, 2]               | [2, 3, 4]                  || [2]
        null                       | [1,2]                      || []
        [Integer.MAX_VALUE, 0]     | [0, -1, Integer.MAX_VALUE] || [0, Integer.MAX_VALUE]
    }

    def "java: find intersection of two lists of Strings" () {
        expect:
        Day16.findIntersection(list1, list2) == expected

        where:
        list1                                          | list2                                          || expected
        ["banana", "apple", "cherry", "banana"]        | ["date", "cherry", "apple", "apple"]           || ["apple", "cherry"]
        []                                             | []                                             || []
        null                                           | null                                           || []
        ["a", "a", "a"]                                | ["a"]                                          || ["a"]
        ["x", "y", "z"]                                | ["a", "b", "c"]                                || []
        ["apple", "banana", "apple"]                   | ["banana", "Banana"]                           || ["banana"]
        ["delta", "alpha"]                             | ["alpha", "charlie", "delta", "alpha"]         || ["alpha", "delta"]
        ["apple", "cherry", "banana"]                  | ["banana", "apple"]                            || ["apple", "banana"]
    }

    def "java: find intersection of two lists of Persons" () {
        expect:
        Day16.findIntersection(list1, list2) == expected

        where:
        list1                                                                                                   | list2                                                                      || expected
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 40), new Person("Bob", 25)]      | [new Person("Eve", 20), new Person("Charlie", 40), new Person("Bob", 25)]  || [new Person("Bob", 25), new Person("Charlie", 40)]
        []                                                                                                      | []                                                                         || []
        [new Person("Bob", 25), new Person("Bob", 25), new Person("Alice", 30)]                                 | [new Person("Bob", 25)]                                                    || [new Person("Bob", 25)]
        [new Person("Alice", 30)]                                                                               | [new Person("Bob", 25)]                                                    || []
        [new Person("Charlie", 40), new Person("Bob", 25)]                                                      | [new Person("Bob", 25), new Person("Charlie", 40)]                         || [new Person("Bob", 25), new Person("Charlie", 40)]
        [new Person("Bob", 25), new Person("Bob", 30)]                                                          | [new Person("Bob", 30)]                                                    || [new Person("Bob", 30)]
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Bob", 25), new Person("Charlie", 40), new Person("Charlie", 40)]
                | [new Person("Bob", 25), new Person("Charlie", 40), new Person("Charlie", 40)] || [new Person("Bob", 25), new Person("Charlie", 40)]
    }

    def "kotlin: find intersection of two lists of Integers"() {
        expect:
        Day16Kt.findIntersection(list1, list2) == expected

        where:
        list1                      | list2                      || expected
        [4, 1, 2, 3, 2, 5]         | [3, 2, 6, 2, 4]            || [2, 3, 4]
        []                         | []                         || []
        [1, 1, 1]                  | [1]                        || [1]
        [3, 2, 1]                  | [4, 5, 6]                  || []
        [5, 4, 3, 3, 2]            | [2, 3, 3, 7]               || [2, 3]
        [2, 2, 2, 2]               | [2, 3, 4]                  || [2]
        null                       | [1,2]                      || []
        [Integer.MAX_VALUE, 0]     | [0, -1, Integer.MAX_VALUE] || [0, Integer.MAX_VALUE]
    }

    def "kotlin: find intersection of two lists of Strings" () {
        expect:
        Day16Kt.findIntersection(list1, list2) == expected

        where:
        list1                                          | list2                                          || expected
        ["banana", "apple", "cherry", "banana"]        | ["date", "cherry", "apple", "apple"]           || ["apple", "cherry"]
        []                                             | []                                             || []
        null                                           | null                                           || []
        ["a", "a", "a"]                                | ["a"]                                          || ["a"]
        ["x", "y", "z"]                                | ["a", "b", "c"]                                || []
        ["apple", "banana", "apple"]                   | ["banana", "Banana"]                           || ["banana"]
        ["delta", "alpha"]                             | ["alpha", "charlie", "delta", "alpha"]         || ["alpha", "delta"]
        ["apple", "cherry", "banana"]                  | ["banana", "apple"]                            || ["apple", "banana"]
    }


    def "groovy: find intersection of two lists of Integers"() {
        expect:
        Day16Groovy.findIntersection(list1, list2) == expected

        where:
        list1                                  | list2                                          || expected
        [10, 5, 5, 2, -1]                      | [5, 5, 10, 11]                                 || [5, 10]
        [Integer.MIN_VALUE, 0, 1]              | [Integer.MIN_VALUE, Integer.MIN_VALUE, 2]      || [Integer.MIN_VALUE]
        [7, 7, 7]                              | []                                             || []
        null                                   | [1, 2, 3]                                      || []
    }

    def "groovy: find intersection of two lists of Persons"() {
        expect:
        Day16Groovy.findIntersection(list1, list2) == expected

        where:
        list1                                                                   | list2                                                             || expected
        [new Person("Zoe", 22), new Person("Anna", 30), new Person("Anna", 30)] | [new Person("Anna", 30), new Person("Ben", 25)]                   || [new Person("Anna", 30)]
        []                                                                      | [new Person("Sam", 20)]                                           || []
        [new Person("Sam", 20), new Person("Sam", 25)]                          | [new Person("Sam", 25), new Person("Sam", 25)]                    || [new Person("Sam", 25)]
        [new Person("Liam", 31), new Person("Olivia", 28)]                      | [new Person("Olivia", 28), new Person("Liam", 31)]                || [new Person("Liam", 31), new Person("Olivia", 28)]
    }


}
