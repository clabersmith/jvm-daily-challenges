import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import support.Person

/**
 * Problem:
 * Remove all occurrences of a given value from a list.
 *
 * Given a list of elements and a target value, write a function that returns
 * a new list containing all elements except those equal to the target value.
 * The relative order of the remaining elements should be preserved.
 *
 * Rules and Constraints:
 * - The input list may be empty.
 * - The list may contain multiple occurrences of the target value.
 * - If the target value does not exist in the list, the original list should
 *   be returned unchanged.
 * - The solution should not modify the original list unless explicitly stated.
 *
 * Examples:
 * - Input:  [1, 2, 3, 2, 4], value = 2
 *   Output: [1, 3, 4]
 *
 * - Input:  ["a", "b", "a", "c"], value = "a"
 *   Output: ["b", "c"]
 */
class Day13Spec extends Specification {

    private static Object removeValueFromList(String impl, Object value, List list) {
        switch(impl) {
            case 'java':   return Day13.removeValueFromList(value, list)
            case 'kotlin': return Day13Kt.removeValueFromList(value, list)
            case 'groovy': return Day13Groovy.removeValueFromList(value, list)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: remove value from list of Integers"() {
        expect:
        removeValueFromList(impl as String, value, list as List) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list            | value || expected
                        [[],                2,      []],
                        [[1, 2, 3, 2, 4],   2,      [1, 3, 4]],
                        [[5, 6, 7],         2,      [5, 6, 7]],
                        [[1, 2, 3, 2, 8],   3,      [1, 2, 2, 8]],
                        [[2, 2, 2],         2,      []]
                ]
        ].combinations()  //returns cartesian product of impl and data

        list     = data[0]
        value    = data[1]
        expected = data[2]
    }

    def "#impl: remove value from list of Strings"() {
        expect:
        removeValueFromList(impl as String, value, list as List) == expected

        where:
        [impl, data] << [
                ['java','kotlin','groovy'],
                [
                        // list               | value  || expected
                        [[],                   "a",    []],
                        [["a", "b", "a", "c"], "a",    ["b", "c"]],
                        [["x", "y"],           "z",    ["x", "y"]],
                        [["a", "a"],           "a",    []],
                        [["a", "b"],           null,   ["a", "b"]]
                ]
        ].combinations()

        list     = data[0]
        value    = data[1]
        expected = data[2]
    }

    def "#impl: remove value from list of Persons"() {
        expect:
        removeValueFromList(impl as String, value, list as List) == expected

        where:
        [impl, data] << [
                ['java','kotlin','groovy'],
                [
                        // list                                                                                                       | value                              || expected
                        [[new Person("Alice", 30), new Person("Bob", 25), new Person("Alice", 30)],   new Person("Alice", 30),   [new Person("Bob", 25)]],
                        [[],                                                                                                          new Person("Alice", 30),   []],
                        [[new Person("Alice", 30), new Person("Alice", 30), new Person("Bob", 25)],   new Person("Alice", 30),   [new Person("Bob", 25)]],
                        [[new Person("Alice", 30), new Person("Bob", 25), new Person("Alice", 30)],   new Person("Bob", 25),     [new Person("Alice", 30), new Person("Alice", 30)]],
                        [[null],                                                                                                      new Person("Alice", 30),   [null]]
                ]
        ].combinations()

        list     = data[0]
        value    = data[1]
        expected = data[2]
    }

}
