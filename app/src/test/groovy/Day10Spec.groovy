import spock.lang.Specification

/**
 * Problem:
 * Determine whether a given string contains only unique characters.
 *
 * Rules and Constraints:
 * - The comparison should be case-sensitive.
 * - All characters in the string should be considered, including spaces
 *   and punctuation.
 * - An empty string should be considered as having all unique characters.
 *
 * Examples:
 * - "abcdef" → true
 * - "hello"  → false
 * - "Java"   → true
 * - ""       → true
 */
class Day10Spec extends Specification {

    def "java: unique and non-unique cases"() {
        expect:
        Day10.isUniqueCharacters(input) == expected

        where:
        input               | expected
        "hel word"          | true
        "A1!b2@c3#"         | true
        "A2!b2@c3#"         | false
        "a b c d e f a"     | false
        ""                  | true
        "Aa"                | true
    }

    def "kotlin: parameterized unique character checks"() {
        expect:
        Day10Kt.isUniqueCharacters(input) == expected

        where:
        input               | expected
        "AbC!@#123"         | true
        "Kotlin!!Rocks"     | false
        "a b\tc\nd"         | true
        "HELLO"             | false
        "üñîq😊"            | true
        "aA1"               | true
    }

    def "groovy: combined unique and non-unique cases"() {
        expect:
        Day10Groovy.isUniqueCharacters(input) == expected

        where:
        input                          | expected
        "!~[]{}:;?/0123456789"         | true
        "oops??"                       | false
        "g r\tuvy\n"                   | true
        "gröövy"                       | false
        "z"                            | true
    }
}
