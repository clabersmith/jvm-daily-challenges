import shared.ListNode
import spock.lang.Shared
import spock.lang.Specification
import support.ListNodeHelper

/**
 * Remove Duplicates from a Linked List
 *
 * Problem:
 * Write a function that removes duplicate values from a singly linked list.
 * The function should preserve the original order of first occurrences and
 * modify the list in place when possible.
 *
 * Input:
 * - The head node of a singly linked list.
 * - The list may contain duplicate values appearing in any positions.
 *
 * Output:
 * - The head node of the linked list with all duplicate values removed.
 *
 * Constraints:
 * - The list may be empty or contain a single node.
 * - Node values may be of any type supporting equality comparison.
 * - The relative order of the first occurrence of each value must be preserved.
 *
 * Examples:
 * - Input:  1 → 2 → 2 → 3 → 1
 *   Output: 1 → 2 → 3
 *
 * - Input:  "a" → "b" → "a" → "c"
 *   Output: "a" → "b" → "c"
 *
 * - Input:  empty list
 *   Output: empty list
 */
class Day28Spec extends Specification {

    def setupSpec() {
        ListNodeHelper.addStaticBuilders()
    }

    private static removeDuplicatesFromLinkedList(String impl, ListNode listNode) {
        switch(impl) {
            case 'java':   return Day28.removeDuplicatesFromLinkedList(listNode)
            case 'kotlin': return Day28Kt.removeDuplicatesFromLinkedList(listNode)
            case 'groovy': return Day28Groovy.removeDuplicatesFromLinkedList(listNode)
            default: throw new IllegalArgumentException("Unknown impl: $impl")
        }
    }

    def "#impl: remove duplicates from linked list for Strings"() {
        given:
        def head = ListNodeHelper.buildFromList(list)

        when:
        removeDuplicatesFromLinkedList(impl as String, head)

        then:
        ListNodeHelper.convertToList(head) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list                         || expected
                        [[],                            []],
                        [["a","b","a","c"],             ["a","b","c"]],
                        [["1","2","2","3","1"],         ["1","2","3"]],
                        [["x","x","x"],                 ["x"]],
                        [["a","b","c","d"],             ["a","b","c","d"]],
                        [["a","b","c","a","d","e","b","f","g","h","i","j","k","l","m","n","o","p","q","a"],
                                                        ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q"]],
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }

    def "#impl: remove duplicates from linked list for Integers"() {
        given:
        def head = ListNodeHelper.buildFromList(list)

        when:
        removeDuplicatesFromLinkedList(impl as String, head)

        then:
        ListNodeHelper.convertToList(head) == expected

        where:
        [impl, data] << [
                ['java', 'kotlin', 'groovy'],
                [
                        // list                         || expected
                        [[],                            []],
                        [[1,2,2,3,1],                   [1,2,3]],
                        [[2,2,2],                       [2]],
                        [[1,2,3,4],                     [1,2,3,4]],
                        [[5,6,5,7,6,8],                 [5,6,7,8]],
                        [[1,2,3,4,5,6,7,8,9,1,2,10,11,12,10,13,14,15,16,17,18,19,13,20,21],
                                                        [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21]],
                ]
        ].combinations()

        list     = data[0]
        expected = data[1]
    }
}
