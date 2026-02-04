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

    private static <T> Object rotateArray(String impl, T[] array, int n) {
        switch(impl) {
            case 'java':   return Day18.rotateArray(array, n)
            case 'kotlin':   return Day18Kt.rotate(array, n)
            case 'groovy':   return Day18Groovy.rotateArray(array, n)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: rotate array of Integers"() {
        expect:
        rotateArray(impl as String, array as Integer[], n as int) == expected

        where:
        [impl, data] << [
            ['java', 'kotlin', 'groovy'],
            [
                // array                       | n   || expected
                [[1, 2, 3, 4, 5],                2,      [4, 5, 1, 2, 3]],
                [[1, 2, 3, 4, 5],               -1,      [2, 3, 4, 5, 1]],
                [[1, 2, 3, 4, 5],                5,      [1, 2, 3, 4, 5]],
                [[1, 2, 3, 4, 5],                7,      [4, 5, 1, 2, 3]],
                [[],                             3,      []],
                [[42],                          10,      [42]],
                [[1, 2, 2, 3],                   2,      [2, 3, 1, 2]],
                [[1, 2],                         1,      [2, 1]]
            ]
        ].combinations()

        array    = data[0]
        n        = data[1]
        expected = data[2] as Integer[]
    }

    def "#impl: rotate array of Strings"() {
        expect:
        rotateArray(impl as String, array as String[], n as int) == expected

        where:
        [impl, data] << [
            ['java', 'kotlin', 'groovy'],
            [
                // array                      | n   || expected
                [["a", "b", "c"],               3,      ["a", "b", "c"]],
                [["x", "y", "z", "w"],         -1,      ["y", "z", "w", "x"]],
                [["a", "b", "c"],               2,      ["b", "c", "a"]],
                [[],                            1,      []],
                [["a", "b", "a", "c"],         -2,      ["a", "c", "a", "b"]]
            ]
        ].combinations()

        array    = data[0]
        n        = data[1]
        expected = data[2] as String[]
    }

    def "#impl: rotate array of Persons"() {
        expect:
        rotateArray(impl as String, array as Person[], n as int) == expected

        where:
        [impl, data] << [
            ['java', 'kotlin', 'groovy'],
            [
                // array
                // n
                // expected
                [
                    [new Person("Alice", 30), new Person("Bob", 25), new Person("Carol", 40)],
                    1,
                    [new Person("Carol", 40), new Person("Alice", 30), new Person("Bob", 25)]
                ],
                [
                    [new Person("Alice", 30), new Person("Bob", 25), new Person("Bob", 55)],
                    2,
                    [new Person("Bob", 25), new Person("Bob", 55), new Person("Alice", 30)]
                ],
                [
                    [new Person("Dave", 20), new Person("Eve", 22), new Person("Frank", 24), new Person("Grace", 26)],
                    3,
                    [new Person("Eve", 22), new Person("Frank", 24), new Person("Grace", 26), new Person("Dave", 20)]
                ],
                [
                    [new Person("Hank", 50), new Person("Ivy", 55), new Person("Jack", 60)],
                    -1,
                    [new Person("Ivy", 55), new Person("Jack", 60), new Person("Hank", 50)]
                ]
            ]
        ].combinations()

        array    = data[0]
        n        = data[1]
        expected = data[2] as Person[]
    }

}
