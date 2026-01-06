import spock.lang.Specification

/**
 * Compress a string by character counts.
 *
 * Write a function that takes a single string and returns a compressed representation
 * where each run of consecutive identical characters is replaced by the character
 * followed by the number of times it appears in that run.
 *
 * Rules and Constraints:
 * - Compression is case-sensitive (\"a\" and \"A\" are different).
 * - All characters are treated literally (letters, digits, whitespace, punctuation).
 * - Only consecutive runs are combined; separate runs of the same character are
 *   compressed independently.
 * - The function should return the compressed string (no requirement to return the
 *   shorter of original vs compressed unless specified).
 *
 * Examples:
 * - \"aabcc\" -> \"a2b1c2\"
 * - \"aaAA\"  -> \"a2A2\"
 * - \"a a\"   -> \"a1 1a1\" (space is a character and is counted)
 */
class Day07Spec extends Specification {

    def "java: compress multiple cases"() {
        expect:
        Day07.compress(input) == expected

        where:
        input    | expected
        "aabcc"  | "a2b1c2"
        "aaAA"   | "a2A2"
        "a a"    | "a1 1a1"
        "aba"    | "a1b1a1"
        "a11bb"  | "a112b2"
    }

    def "kotlin: compress multiple cases"() {
        expect:
        Day07Kt.compress(input) == expected

        where:
        input     | expected
        ""        | ""
        "x"       | "x1"
        "   "     | " 3"
        "AaA"     | "A1a1A1"
        "112233"  | "122232"
        "!!!??!"  | "!3?2!1"
        "zzzzzz"  | "z6"
    }

    def "groovy: compress various cases"() {
        expect:
        Day07Groovy.compress(input) == expected

        where:
        input    | expected
        "abc"    | "a1b1c1"
        "zzzzz"  | "z5"
        "aA"     | "a1A1"
        "a!a!"   | "a1!1a1!1"
    }
}
