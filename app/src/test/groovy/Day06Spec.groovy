import spock.lang.Specification

/**
 * Check if Two Strings Are Anagrams
 *
 * Write a function that determines whether two strings are anagrams of each other.
 *  Two strings are anagrams if they contain the same characters in the same quantities,
 *  but possibly in a different order.
 *
 * Rules:
 *  - Comparison should be case-insensitive.
 *  - Ignore whitespace in the strings.
 *  - All other characters (letters, digits, punctuation) should be considered.
 *  - The order of characters does not matter, so identical strings will be considered anagrams
 *
 * If the two strings are anagrams, return true; otherwise, return false.
*/
class Day06Spec extends Specification {
    def "java: check anagrams"() {
        when:
        def result = Day06.isAnagrams(input1, input2)

        then:
        result == expected

        where:
        input1             | input2              || expected
        "listen"           | "silent"            || true   // basic anagram
        "Triangle"         | "Integral"          || true   // case-insensitive
        "anagram"          | "nag a ram"         || true   // ignore whitespace
        "Apple"            | "Papal"             || false  // different counts
        "123@!"            | "!321@"             || true   // digits & punctuation considered
        "a.b,c!"           | "c!b.a,"            || true   // punctuation handling
        "same"             | "same"              || true   // identical strings
    }

    def "kotlin: check anagrams"() {
        expect:
        Day06Kt.isAnagrams(input1, input2) == expected

        where:
        input1                   | input2                   || expected
        "Dormitory"              | "Dirty room"             || true
        "The Morse Code"         | "Here come dots"         || true
        "School master"          | "The classroom"          || true
        "eleven plus two"        | "twelve plus one"        || true
        "42#!"                   | "!#24"                   || true
        "abc"                    | "ab"                     || false
    }

    def "groovy: check anagrams"() {
        expect:
        Day06Groovy.isAnagrams(input1, input2) == expected

        where:
        input1           | input2             || expected
        "Debit Card"     | "Bad Credit"       || true
        "Astronomer"     | "Moon starer"      || true
        "Conversation"   | "Voices rant onx"  || false
        "Funeral"        | "Real fun"         || true
        "abc!!"          | "ab!!c"            || true
    }
}
