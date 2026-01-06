import spock.lang.Specification

/**
 * Problem:
 * Count the number of vowels in a given string.
 *
 * Rules and Constraints:
 * - Vowels are defined as: a, e, i, o, u (both lowercase and uppercase).
 * - The comparison should be case-insensitive.
 * - All characters in the string should be considered.
 * - An empty string should return a count of 0.
 *
 * Examples:
 * - "hello"   → 2
 * - "JAVA"    → 2
 * - "rhythm"  → 0
 * - ""        → 0
 */
class Day03Spec extends Specification {
    def "java vowel count"() {
        expect:
        Day03.countVowels(input) == expected

        where:
        which                     | input                 | expected
        "mixed case and words"    | "JAVA has streams"    | 5
        "all uppercase vowels"    | "AEIOU"               | 5
        "no vowels"               | "rhythm"              | 0
        "empty string"            | ""                    | 0
        "mixed characters"        | "123 a!E"             | 2
    }

    def "kotlin vowel count"() {
        expect:
        Day03Kt.countVowels(input) == expected

        where:
        which                       | input                       | expected
        "mixed words"               | "KOTLIN has extensions"     | 7
        "single uppercase word"     | "KOTLIN"                    | 2
        "punctuation and apostrophe"| "Kotlin's extensions!"      | 6
        "no vowels"                 | "rhythms"                   | 0
        "empty string"              | ""                          | 0
    }

    def "groovy vowel count"() {
        expect:
        Day03Groovy.countVowels(input) == expected

        where:
        which                    | input                  | expected
        "mixed case words"       | "GROOVY uses closures" | 7
        "single word uppercase"  | "GROOVY"               | 2
        "contains punctuation"   | "groovy, java!"        | 4
        "no vowels"              | "rhythms"              | 0
        "empty string"           | ""                     | 0
    }
}
