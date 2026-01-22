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

    def "java: find item using binary search in list of Integers"() {
        expect:
        def actual = Day21.binarySearchSortedList(list as List<Integer>, target)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        list                                            | target || expected
        [1, 3, 5, 7, 9]                                 | 5      || 2
        [1, 3, 5, 7, 9]                                 | 6      || { it -> assert it < 0; return true }
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]
                                                        | 15     || 15
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
                                                        | 42     || 42
        [7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7]
                                                        | 7      ||  { it -> assert it > -1; return true }
        []                                              | 1      ||  { it -> assert it < 0; return true }
    }

    def "java: find item using binary search in list of Strings"() {
        expect:
        def actual = Day21.binarySearchSortedList(list as List<String>, target)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        list                                        | target    || expected
        ["apple","banana","cherry","date"]          | "cherry"  || 2
        ["apple","banana","cherry","date"]          | "apricot" || { it -> assert it < 0; return true }
        ["a","b","c","d","e"]                       | "a"       || 0
        ["a","b","c","d","e"]                       | "e"       || 4
        ["x","x","x","x","x","x"]                   | "x"       || { it -> assert it > -1; return true }
        []                                          | "hello"   || { it -> assert it < 0; return true }
        ["Alpha","beta","gamma"]                    | "beta"    || 1
        ["apple","banana","banana","carrot"]        | "banana"  || { it -> assert it in [1,2]; return true }
        ["ant","bee","cat","dog","eel","fox"]       | "eel"     || 4
        ["aa","ab","ac","ad","ae","af","ag","ah"]   | "ah"      || 7
        null                                        | "null"    || { it -> assert it < 0; return true }
    }

    def "kotlin: find item using binary search in list of Persons"() {
        expect:
        def actual = Day21Kt.binarySearchSortedList(list as List<Person>, target)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        list                                                                            | target                        || expected
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 20)]     | new Person("Bob", 25)         || 1
        [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 20)]     | new Person("Dan", 40)         || { it -> assert it < 0; return true }
        [new Person("Eve", 20), new Person("Eve", 25), new Person("Frank", 30)]         | new Person("Eve", 25)         || { it -> assert it in [0,1]; return true }
        [new Person("Sam", 20), new Person("Sam", 30)]                                  | new Person("Sam", 30)         || 1
        []                                                                              | new Person("Nobody", 0)       || { it -> assert it < 0; return true }
    }

    def "groovy: find item using binary search in list of Doubles"() {
        expect:
        def actual = Day21Groovy.binarySearchSortedList(list as List<Double>, target)
        expected instanceof Closure ? expected(actual) : actual == expected

        where:
        list                                        | target     || expected
        [1.1d, 2.2d, 3.3d, 4.4d, 5.5d]              | 3.3d       || 2
        [1.0d, 2.0d, 3.0d]                          | 4.0d       || { it -> assert it < 0; return true }
        [0.5d, 1.5d, 2.5d, 3.5d, 4.5d]              | 0.5d       || 0
        [9.9d, 9.9d, 9.9d, 9.9d]                    | 9.9d       || { it -> assert it > -1; return true }
        []                                          | 1.23d      || { it -> assert it < 0; return true }
    }

}