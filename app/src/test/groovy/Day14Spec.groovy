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

     def "java: merge two sorted Integer lists maintaining sort"() {
         expect:
         Day14.mergeSortedLists(left as List<Integer>, right as List<Integer>) == expected

         where:
         left             | right            || expected
         []               | []               || []
         []               | [4, 7, 9]        || [4, 7, 9]
         [1, 3, 5]        | [2, 4, 6]        || [1, 2, 3, 4, 5, 6]
         [1, 2, 3]        | [1, 2, 3]        || [1, 1, 2, 2, 3, 3]
         [1, 4, 5]        | [2, 3, 6]        || [1, 2, 3, 4, 5, 6]
         [-3, -1, 0]      | [-2, 1]           || [-3, -2, -1, 0, 1]
         [1]              | []               || [1]
         []               | [1]              || [1]
         [1, 1, 1]        | [1, 1]           || [1, 1, 1, 1, 1]
     }

     def "java: merge two sorted String lists maintaining sort"() {
         expect:
         Day14.mergeSortedLists(left as List<String>, right as List<String>) == expected

         where:
         left              | right                       || expected
         []                | []                          || []
         []                | ["banana", "orange"]        || ["banana", "orange"]
         ["apple", "pear"] | ["banana", "orange"]        || ["apple", "banana", "orange", "pear"]
         ["a", "c"]        | ["b", "d"]                  || ["a", "b", "c", "d"]
     }

    def "java: merge two sorted Person lists maintaining sort by name"() {
         expect:
         Day14.mergeSortedLists(left as List<Person>, right as List<Person>) == expected

         where:
         left                                                            | right                                                   || expected
         []                                                              | [new Person("Aaron", 20), new Person("Beth", 35)]       || [new Person("Aaron", 20), new Person("Beth", 35)]
         [new Person("Alice", 30), new Person("Charlie", 25)]            | [new Person("Aaron", 20), new Person("Beth", 35)]       || [new Person("Aaron", 20), new Person("Alice", 30),  new Person("Beth", 35), new Person("Charlie", 25)]
         [new Person("Alice", 22)]                                       | [new Person("Alice", 30)]                               || [new Person("Alice", 22), new Person("Alice", 30)]
         [new Person("Bob", 25)]                                         | []                                                      || [new Person("Bob", 25)]
    }

    def "kotlin: merge two sorted Integer lists maintaining sort"() {
        expect:
        Day14Kt.mergeSortedLists(left as List<Integer>, right as List<Integer>) == expected

        where:
        left             | right            || expected
        []               | []               || []
        [1, 3, 5]        | [2, 4, 6]        || [1, 2, 3, 4, 5, 6]
        [1]              | []               || [1]
    }

    def "kotlin: merge two sorted Person lists maintaining sort by name"() {
        expect:
        Day14Kt.mergeSortedLists(left as List<Person>, right as List<Person>) == expected

        where:
        left                                                            | right                                                   || expected
        []                                                              | [new Person("Aaron", 20), new Person("Beth", 35)]       || [new Person("Aaron", 20), new Person("Beth", 35)]
        [new Person("Alice", 30)]                                       | [new Person("Bob", 25)]                                 || [new Person("Alice", 30), new Person("Bob", 25)]
        [new Person("Alice", 22), new Person("Alice", 28)]              | [new Person("Charlie", 20), new Person("Charlie", 24)]  || [new Person("Alice", 22), new Person("Alice", 28), new Person("Charlie", 20), new Person("Charlie", 24)]
    }

    def "groovy: additional merge two sorted String lists (duplicates and mixed)"() {
            expect:
            Day14Groovy.mergeSortedLists(left as List<String>, right as List<String>) == expected

            where:
            left                        | right                               || expected
            []                          | []                                  || []
            ["ant", "dog"]              | ["bee", "cat"]                      || ["ant", "bee", "cat", "dog"]
            ["apple", "apple", "pear"]  | ["apple", "banana", "banana", "z"]  || ["apple", "apple", "apple", "banana", "banana", "pear", "z"]
        }

    def "groovy: additional merge two sorted Person lists (duplicate names / ages)"() {
        expect:
        Day14Groovy.mergeSortedLists(left as List<Person>, right as List<Person>) == expected

        where:
        left                                                        | right                                                   || expected
        [new Person("Dan", 50), new Person("Zoe", 20)]              | [new Person("Dan", 40), new Person("Mike", 30)]         || [new Person("Dan", 40), new Person("Dan", 50), new Person("Mike", 30), new Person("Zoe", 20)]
        [new Person("Sam", 25)]                                     | [new Person("Sam", 25)]                                 || [new Person("Sam", 25), new Person("Sam", 25)]
    }

 }