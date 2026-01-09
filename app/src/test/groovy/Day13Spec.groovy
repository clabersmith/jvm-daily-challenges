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

    @Shared Person p1 = new Person("Alice", 30)
    @Shared Person p2 = new Person("Bob", 25)
    @Shared Person p3 = new Person("Alice", 30) // equal to p1

    def "java: remove value from list of Integers"() {
        expect:
        Day13.removeValueFromList(value, list) == expected

        where:
        list                           | value   || expected
        []                             | 2       || []
        [1, 2, 3, 2, 4]                | 2       || [1, 3, 4]
        [5, 6, 7]                      | 2       || [5, 6, 7]
        [1, 2, 3, 2, 8]                | 3       || [1, 2, 2, 8]
        [2, 2, 2]                      | 2       || []
    }

    def "java: remove value from list of Strings"() {
        expect:
        Day13.removeValueFromList(value, list) == expected

        where:
        list                          | value || expected
        []                            | "a"   || []
        ["a", "b", "a", "c"]          | "a"   || ["b", "c"]
        ["x", "y"]                    | "z"   || ["x", "y"]
        ["a", "a"]                    | "a"   || []
        ["a", "b"]                    | null  || ["a", "b"]
    }

    @Unroll("Iteration #iterationIndex of java Persons test")
    def "java: remove value from list of Persons"() {
        expect:
        Day13.removeValueFromList(value, list) == expected

        where:
        list                       | value || expected
        [p1, p2, p3]               | p1    || [p2]
        []                         | p1    || []
        [p1, p1, p2]               | p1    || [p2]
        [p1, p2, p3]               | p2    || [p1, p3]
        [null]                     | p1    || [null]
    }

    def "kotlin: remove value from list of Strings"() {
        expect:
        Day13Kt.removeValueFromList(value, list) == expected

        where:
        list                          | value || expected
        []                            | "a"   || []
        ["a", "b", "a", "c"]          | "a"   || ["b", "c"]
        ["x", "y"]                    | "z"   || ["x", "y"]
        ["a", "a"]                    | "a"   || []
        []                            | null  || []

    }

    @Unroll("Iteration #iterationIndex of kotlin Persons test")
    def "kotlin: remove value from list of Persons"() {
        expect:
        Day13Kt.removeValueFromList(value, list) == expected

        where:
        list                       | value || expected
        [p1, p2, p3]               | p1    || [p2]
        []                         | p1    || []
        [p1, p1, p2]               | p1    || [p2]
        [p1, p2, p3]               | p2    || [p1, p3]
        [null, p3]                 | null  || [p3]
    }

    def "groovy: remove value from list of Integers"() {
        expect:
        Day13Groovy.removeValueFromList(value, list) == expected

        where:
        list                         | value || expected
        [0, 2, 2, 3]                 | 2     || [0, 3]
        [9, 8, 9, 7]                 | 9     || [8, 7]
        [1, 1, 1, 1, 1]              | 1     || []
        [null, 1, null, 2]           | null  || [1, 2]
        [null, null]                 | null  || []

    }

    @Unroll("Iteration #iterationIndex of groovy Persons test")
    def "groovy: remove value from list of Persons"() {
        expect:
        Day13Groovy.removeValueFromList(value, list) == expected

        where:
        list                          | value || expected
        [p2, p1, p3, p1]              | p1    || [p2]
        [p3, p3, p2, p1, p2]          | p3    || [p2, p2]
        [null, null]                  | p1    || [null, null]
    }

}
