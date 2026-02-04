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

    private static Object findIntersection(String impl, List list1, List list2) {
        switch(impl) {
            case 'java':   return Day16.findIntersection(list1, list2)
            case 'kotlin':   return Day16Kt.findIntersection(list1, list2)
            case 'groovy':   return Day16Groovy.findIntersection(list1, list2)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: find intersection of two lists of Integers"() {
        expect:
        findIntersection(impl as String, list1 as List<Integer>, list2 as List<Integer>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list1                    |list2                      || expected
                        [[4, 1, 2, 3, 2, 5],         [3, 2, 6, 2, 4],            [2, 3, 4]],
                        [[],                         [],                         []],
                        [[1, 1, 1],                  [1],                        [1]],
                        [[3, 2, 1],                  [4, 5, 6],                  []],
                        [[5, 4, 3, 3, 2],            [2, 3, 3, 7],               [2, 3]],
                        [[2, 2, 2, 2],               [2, 3, 4],                  [2]],
                        [null,                       [1, 2],                     []],
                        [[Integer.MAX_VALUE, 0],     [0, -1, Integer.MAX_VALUE], [0, Integer.MAX_VALUE]]
                ]
        ].combinations()

        list1    = data[0]
        list2    = data[1]
        expected = data[2]
    }

    def "#impl: find intersection of two lists of Strings" () {
        expect:
        findIntersection(impl as String, list1 as List<String>, list2 as List<String>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list1                                        |list2                                         || expected
                        [["banana", "apple", "cherry", "banana"],        ["date", "cherry", "apple", "apple"] ,        ["apple", "cherry"]],
                        [[],                                             [],                                           []],
                        [null,                                           null,                                         []],
                        [["a", "a", "a"],                                ["a"],                                        ["a"]],
                        [["x", "y", "z"],                                ["a", "b", "c"],                              []],
                        [["apple", "banana", "apple"],                   ["banana", "Banana"],                         ["banana"]],
                        [["delta", "alpha"],                             ["alpha", "charlie", "delta", "alpha"],       ["alpha", "delta"]],
                        [["apple", "cherry", "banana"],                  ["banana", "apple"],                          ["apple", "banana"]]
                ]
        ].combinations()

        list1    = data[0]
        list2    = data[1]
        expected = data[2]
    }

    def "#impl: find intersection of two lists of Persons" () {
        expect:
        findIntersection(impl as String, list1 as List<Person>, list2 as List<Person>) == expected

        where:
            [impl, data] << [
                    ['java', 'kotlin', 'groovy'],
                    [
                        // list1
                        // list 2
                        // expected
                        [
                                [new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 40), new Person("Bob", 25)],
                                [new Person("Eve", 20),   new Person("Charlie", 40), new Person("Bob", 25)],
                                [new Person("Bob", 25),   new Person("Charlie", 40)]
                        ],
                        [ [], [], [] ],
                        [
                                [new Person("Bob", 25), new Person("Bob", 25), new Person("Alice", 30)],
                                [new Person("Bob", 25)],
                                [new Person("Bob", 25)]
                        ],
                        [
                                [new Person("Alice", 30)],
                                [new Person("Bob", 25)],
                                []
                        ],
                        [
                                [new Person("Charlie", 40), new Person("Bob", 25)],
                                [new Person("Bob", 25), new Person("Charlie", 40)],
                                [new Person("Bob", 25), new Person("Charlie", 40)]
                        ],
                        [
                                [new Person("Bob", 25), new Person("Bob", 30)],
                                [new Person("Bob", 30)],
                                [new Person("Bob", 30)]
                        ],
                        [
                                [new Person("Alice", 30), new Person("Bob", 25), new Person("Bob", 25), new Person("Charlie", 40), new Person("Charlie", 40)],
                                [new Person("Bob", 25), new Person("Charlie", 40), new Person("Charlie", 40)],
                                [new Person("Bob", 25), new Person("Charlie", 40)]
                        ]
                    ]
            ].combinations()

        list1    = data[0]
        list2    = data[1]
        expected = data[2]
    }

}
