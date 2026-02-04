import spock.lang.Specification
import support.Employee

/**
 * Problem:
 * Given a list of elements, determine how many times each distinct element occurs.
 *
 * The input list may contain duplicate values. The result should associate each
 * unique element with the total number of times it appears in the list.  Assume the
 * list object is not null
 *
 * Examples:
 * - Input:  [1, 2, 2, 3, 3, 3]
 *   Output: {1=1, 2=2, 3=3}
 *
 * - Input:  ["apple", "banana", "apple"]
 *   Output: {"apple"=2, "banana"=1}
 *
 * - Input:  []
 *   Output: {}
 */
class Day19Spec extends Specification {

    private static <T> Object countDistinct(String impl, List<T> list) {
        switch(impl) {
            case 'java':   return Day19.countDistinct(list)
            case 'kotlin':   return Day19Kt.countDistinct(list)
            case 'groovy':   return Day19Groovy.countDistinct(list)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: count distinct elements in list of Integers"() {
        expect:
        countDistinct(impl as String, list as List<Integer>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        //list                 ||expected
                        [[1, 2, 2, 3, 3, 3],   [1: 1, 2: 2, 3: 3]],
                        [[],                   [:]],
                        [[5, 5, 5, 5],         [5: 4]],
                        [[1, -1, 1, 0],        [1: 2, (-1): 1, 0: 1]]
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }

    def "#impl: count distinct elements in list of Strings"() {
        expect:
        countDistinct(impl as String, list as List<String>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        [["apple", "banana", "apple"],   ["apple": 2, "banana": 1]],
                        [[],                             [:]],
                        [["x", "x"],                     ["x": 2]],
                        [["a", "A", "a", " "],           ["a": 2, "A": 1, " ": 1]]
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }

    def "#impl: count distinct elements in list of Employees"() {
        expect:
        countDistinct(impl as String, list as List<Employee>) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                    //list
                    //expected
                    [
                        [new Employee(1, "Alice", 30), new Employee(1, "Alice", 30), new Employee(2, "Bob", 25)],
                        [(new Employee(1, "Alice", 30)): 2, (new Employee(2, "Bob", 25)): 1]
                    ],
                    [
                        [],
                        [:]
                    ],
                    [
                        [new Employee(1, "Charlie", 40), new Employee(2, "Charlie", 40), new Employee(1, "Charlie", 40)],
                        [(new Employee(1, "Charlie", 40)): 2, (new Employee(2, "Charlie", 40)): 1]
                    ],
                    [
                        [new Employee(3, "Dana", 28), new Employee(3, "Dana", 28), new Employee(3, "Dana", 28), new Employee(4, "Eve", 28)],
                        [(new Employee(3, "Dana", 28)): 3, (new Employee(4, "Eve", 28)): 1]
                    ]
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }

}


