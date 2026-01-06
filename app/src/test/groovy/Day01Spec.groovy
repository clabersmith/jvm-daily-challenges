import spock.lang.Specification

/**
 * Problem:
 * Determine whether a given string is a palindrome.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 * Rules and Constraints:
 * - The comparison should be case-sensitive.
 * - All characters in the string should be considered, including spaces
 *   and punctuation.
 * - An empty string should be considered a valid palindrome.
 *
 * Examples:
 * - "racecar" → true
 * - "level"   → true
 * - "hello"   → false
 * - ""        → true
 */
class Day01Spec extends Specification {
    def "java palindrome examples"() {
        expect:
        Day01.isPalindrome(input) == expected

        where:
        input                                   | expected
        "racecar"                               | true
        "level"                                 | true
        "hello"                                 | false
        ""                                      | true
        "A"                                     | true
        "Aa"                                    | false    // case-sensitive
        "a a"                                   | true     // spaces considered
        "a b"                                   | false
        "A man, a plan, a canal, Panama"        | false    // punctuation and case are considered
        "!!!"                                   | true
    }

    def "kotlin palindrome examples"() {
        expect:
        Day01Kt.isPalindrome(input) == expected

        where:
        input                       | expected
        "madam"                     | true
        "Noon"                      | false   // case-sensitive
        "abc cba"                   | true    // spaces considered
        "ab cc ba"                  | true
        ""                          | true
        "Z"                         | true
        "Zz"                        | false
        ".,."                       | true
        "A man, a plan"             | false   // punctuation and case considered
    }

    def "groovy palindrome"() {
        expect:
        Day01Groovy.isPalindrome(input) == expected

        where:
        input                 | expected
        "rotor"               | true
        "Rotor"               | false
        "step on no pets"     | true
        "step on no pet"      | false
        "x"                   | true
        "ab!ba"               | true
    }
}
