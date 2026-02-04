import spock.lang.Specification
import support.Person

/**
 * Problem:
 * Merge two sorted lists into a single sorted list.
 *
 * Write a generic function that accepts two lists whose elements are already
 * sorted in ascending order and returns a new list containing all elements
 * from both input lists, also sorted in ascending order.
 *
 * The function should work for any type that can be compared and should not
 * modify the original lists.
 *
 * Examples:
 * - Input: [1, 3, 5] and [2, 4, 6]
 *   Output: [1, 2, 3, 4, 5, 6]
 *
 * - Input: ["apple", "pear"] and ["banana", "orange"]
 *   Output: ["apple", "banana", "orange", "pear"]
 *
 * - Input: [] and [4, 7, 9]
 *   Output: [4, 7, 9]
 *
 * Notes:
 * - Both input lists are guaranteed to be sorted and contain no null values
 * - The element type must be comparable (e.g., T extends Comparable<T>).
 * - Duplicate values should be preserved.
 * - Aim for a linear-time solution relative to the total number of elements.
 */
class Day14Spec extends Specification {

    private static Object mergeSortedLists(String impl, List left, List right) {
        switch(impl) {
            case 'java':   return Day14.mergeSortedLists(left, right)
            case 'kotlin': return Day14Kt.mergeSortedLists(left, right)
            case 'groovy': return Day14Groovy.mergeSortedLists(left, right)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: merge two sorted Integer lists maintaining sort"() {
        expect:
        mergeSortedLists(impl as String, left as List<Integer>, right as List<Integer>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // left            | right            || expected
                        [[],               [],               []],
                        [[],               [4, 7, 9],        [4, 7, 9]],
                        [[1, 3, 5],        [2, 4, 6],        [1, 2, 3, 4, 5, 6]],
                        [[1, 2, 3],        [1, 2, 3],        [1, 1, 2, 2, 3, 3]],
                        [[1, 4, 5],        [2, 3, 6],        [1, 2, 3, 4, 5, 6]],
                        [[-3, -1, 0],      [-2, 1],          [-3, -2, -1, 0, 1]],
                        [[1],              [],               [1]],
                        [[],               [1],              [1]],
                        [[1, 1, 1],        [1, 1],           [1, 1, 1, 1, 1]]
                ]
        ].combinations()

        left     = data[0]
        right    = data[1]
        expected = data[2]
    }

    def "#impl: merge two sorted String lists maintaining sort"() {
        expect:
        mergeSortedLists(impl as String, left as List<String>, right as List<String>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // left             | right                     || expected
                        [[],                [],                         []],
                        [[],                ["banana", "orange"],       ["banana", "orange"]],
                        [["apple", "pear"], ["banana", "orange"],       ["apple", "banana", "orange", "pear"]],
                        [["a", "c"],        ["b", "d"],                 ["a", "b", "c", "d"]]
                ]
        ].combinations()

        left     = data[0]
        right    = data[1]
        expected = data[2]
    }

    def "#impl: merge two sorted Person lists maintaining sort by name"() {
        expect:
        mergeSortedLists(impl as String, left as List<Person>, right as List<Person>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // left                                                                       | right                                                                    || expected
                        [[],                                                                          [new Person("Aaron", 20), new Person("Beth", 35)],   [new Person("Aaron", 20), new Person("Beth", 35)]],
                        [[new Person("Alice", 30), new Person("Charlie", 25)],   [new Person("Aaron", 20), new Person("Beth", 35)],   [new Person("Aaron", 20), new Person("Alice", 30), new Person("Beth", 35), new Person("Charlie", 25)]],
                        [[new Person("Alice", 22)],                                         [new Person("Alice", 30)],                                     [new Person("Alice", 22), new Person("Alice", 30)]],
                        [[new Person("Bob", 25)],                                           [],                                                                       [new Person("Bob", 25)]]
                ]
        ].combinations()

        left     = data[0]
        right    = data[1]
        expected = data[2]
    }
 }