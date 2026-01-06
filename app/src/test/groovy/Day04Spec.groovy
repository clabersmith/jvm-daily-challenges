import spock.lang.Specification

/**
 * Problem:
 * Remove duplicate characters from a given string.
 *
 * Rules and Constraints:
 * - The order of characters should be preserved.
 * - The comparison should be case-sensitive.
 * - All characters in the string should be considered, including spaces
 *   and punctuation.
 * - An empty string should return an empty string.
 *
 * Examples:
 * - "banana"      → "ban"
 * - "hello world" → "helo wrd"
 * - "Java"        → "Jav"
 * - ""            → ""
 */
class Day04Spec extends Specification {
    def "java remove duplicates" () {
        expect:
        Day04.removeDuplicates(input) == expected

        where:
        input           | expected
        "banana"        | "ban"
        "hello world"   | "helo wrd"
        "Java"          | "Jav"
        ""              | ""
    }

    def "kotlin remove duplicates"() {
        expect:
        Day04Kt.removeDuplicates(input) == expected

        where:
        input              | expected
        "HELLO. WOrld."    | "HELO. Wrld"
        "AaAaBb!"          | "AaBb!"
        "112233!!"         | "123!"
        "   "              | " "
    }

    def "groovy remove duplicates"() {
        expect:
        Day04Groovy.removeDuplicates(input) == expected

        where:
        input               | expected
        "1122_334_455"      | "12_345"
        "hello"             | "helo"
        "AaAa"              | "Aa"
        "   "               | " "
    }
}
