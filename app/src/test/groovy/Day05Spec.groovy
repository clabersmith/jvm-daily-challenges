import spock.lang.Specification

/**
 * Problem:
 * Find the first non-repeating character in a given string.
 *
 * Rules and Constraints:
 * - The comparison should be case-sensitive.
 * - All characters in the string should be considered, including spaces
 *   and punctuation.
 * - If no non-repeating character exists, return an empty string.
 * - An empty string should return an empty string.
 *
 * Examples:
 * - "swiss"     → "w"
 * - "aabbcc"    → ""
 * - "hello"     → "h"
 * - ""          → ""
 */
class Day05Spec extends Specification {
    def "java get first non-repeating"() {
        expect:
        Day05.getFirstNonRepeatingChar(input) == expected

        where:
        input                      | expected
        "banana"                   | "b"
        "swiss"                    | "w"
        "aabbcc"                   | ""
        "hello"                    | "h"
        ""                         | ""
        "Hello, Hello,world"       | " "
        "HELLO,WOrld,Hello."       | "E"
        "bananab"                  | ""
        "1136324"                  | "6"
    }

    def "kotlin get first non-repeating"() {
        expect:
        Day05Kt.getFirstNonRepeatingChar(input) == expected

        where:
        input        | expected
        "swiss"      | "w"
        "aabbcc"     | ""
        "x"          | "x"
        " "          | " "
        "abca"       | "b"
        "AbBa"       | "A"
        "bananab"    | ""
        "1231234"    | "4"
    }

    def "groovy get first non-repeating"() {
        expect:
        Day05Groovy.getFirstNonRepeatingChar(input) == expected

        where:
        input        | expected
        "swiss"      | "w"
        "aabbcc"     | ""
        "x"          | "x"
        " "          | " "
        "abca"       | "b"
        "AbBa"       | "A"
        "bananab"    | ""
        "1231234"    | "4"
    }
}
