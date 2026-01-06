import spock.lang.Specification

/**
 * Problem:
 * Reverse a string without using built-in reverse functions
 *
 * Implement a solution with the same rules as the Day 01 challenge, but without using reverse/reversed
 */
class Day02Spec extends Specification {
    def "java palindrome examples"() {
        expect:
        Day02.isPalindrome(input) == expected

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
        Day02Kt.isPalindrome2(input) == expected

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
        Day02Groovy.isPalindrome(input) == expected

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
