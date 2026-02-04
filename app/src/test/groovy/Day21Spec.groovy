import spock.lang.Specification
import support.Person

/**
 * Problem:
 * Implement binary search on a sorted list.
 *
 * Given a sorted list of elements and a target value, return the index of the
 * target in the list. If the target does not exist in the list, indicate this
 * appropriately (e.g., by returning -1).
 *
 * Constraints:
 * - The input list is sorted in ascending order.
 * - The list may contain duplicate values; returning the index of any matching
 *   element is acceptable.
 * - The list may be empty.
 *
 * Examples:
 * - Input:  [1, 3, 5, 7, 9], target = 5
 *   Output: 2
 *
 * - Input:  [1, 3, 5, 7, 9], target = 6
 *   Output: -1
 *
 * - Input:  [], target = 1
 *   Output: -1
 */
class Day21Spec extends Specification {

    private static <E extends Comparable<E>> Object binarySearchSortedList(String impl, List<E> list, E target) {
        switch(impl) {
            case 'java':   return Day21.binarySearchSortedList(list, target)
            case 'kotlin':   return Day21Kt.binarySearchSortedList(list, target)
            case 'groovy':   return Day21Groovy.binarySearchSortedList(list, target)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: find item using binary search in list of Integers"() {
        expect:
        def actual = binarySearchSortedList(impl as String, list as List<Integer>, target as Integer)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        [impl, data] << [
            ['java', 'kotlin', 'groovy'],
            [
                //list                                    |target   |expected
                [[1, 3, 5, 7, 9],                          5,       2],
                [[1, 3, 5, 7, 9],                          6,       { it -> assert it < 0; return true }],
                [(0..30).toList(),                         15,      15],
                [(0..100).toList(),                        42,      42],
                [(0..25).collect { 7 },        7,       { it -> assert it > -1; return true }],
                [[],                                       1,       { it -> assert it < 0; return true }]
            ]
        ].combinations()

        list     = data[0]
        target   = data[1]
        expected = data[2]
    }

    def "#impl: find item using binary search in list of Strings"() {
        expect:
        def actual = binarySearchSortedList(impl as String, list as List<String>, target as String)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        [impl, data] << [
            ['java', 'kotlin', 'groovy'],
            [
                //list                                         |target     |expected
                [["apple","banana","cherry","date"],           "cherry",   2],
                [["apple","banana","cherry","date"],           "apricot",  { it -> assert it < 0; return true }],
                [["a","b","c","d","e"],                        "a",        0],
                [["a","b","c","d","e"],                        "e",        4],
                [["x","x","x","x","x","x"],                    "x",        { it -> assert it > -1; return true }],
                [[],                                          "hello",     { it -> assert it < 0; return true }],
                [["Alpha","beta","gamma"],                     "beta",     1],
                [["apple","banana","banana","carrot"],         "banana",   { it -> assert it in [1,2]; return true }],
                [["ant","bee","cat","dog","eel","fox"],        "eel",      4],
                [["aa","ab","ac","ad","ae","af","ag","ah"],    "ah",       7],
                [null,                                        "null",      { it -> assert it < 0; return true }]
            ]
        ].combinations()

        list     = data[0]
        target   = data[1]
        expected = data[2]
    }

    def "#impl: find item using binary search in list of Persons"() {
        expect:
        def actual = binarySearchSortedList(impl as String, list as List<Person>, target as Person)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        [impl, data] << [
            ['java', 'kotlin', 'groovy'],
            [
                //list
                //target
                //expected
                [
                    [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 20)],
                    new Person("Bob", 25),
                    1
                ],
                [
                    [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 20)],
                    new Person("Dan", 40),
                    { it -> assert it < 0; return true }
                ],
                [
                    [new Person("Eve", 20), new Person("Eve", 25), new Person("Frank", 30)],
                    new Person("Eve", 25),
                    { it -> assert it in [0,1]; return true }
                ],
                [
                    [new Person("Sam", 20), new Person("Sam", 30)],
                    new Person("Sam", 30),
                    1
                ],
                [
                    [],
                    new Person("Nobody", 0),
                    { it -> assert it < 0; return true }
                ]
            ]
        ].combinations()

        list     = data[0]
        target   = data[1]
        expected = data[2]
    }

}