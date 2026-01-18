import spock.lang.Specification

/**
 * Problem:
 * Given a sentence as a string, find and return the longest word in the sentence.
 *
 * A word is defined as a contiguous sequence of non-whitespace characters.
 * If multiple words share the maximum length, return the first one encountered.
 *
 * Examples:
 * - Input:  "The quick brown fox"
 *   Output: "quick"
 *
 * - Input:  "Java and Kotlin are powerful"
 *   Output: "Kotlin"
 *
 * - Input:  ""
 *   Output: ""
 */
class Day20Spec extends Specification {

    def "java: find longest word in sentence"() {
        expect:
        Day20.getLongestWord(sentence) == expected

        where:

        sentence                                        || expected
        "The quick brown fox"                           || "quick"
        "Java and Kotlin are powerful"                  || "powerful"
        ""                                              || ""
        "one two three"                                 || "three"
        "abcd efgh ij"                                  || "abcd"
        "   leading and\ttrailing  spaces  "            || "trailing"
        "punctuation,counts!"                           || "punctuation,counts!"
        "a bb ccc dddd eee"                             || "dddd"
        null                                            || ""
    }

    def "kotlin: find longest word in sentence"() {
        expect:
        Day20Kt.getLongestWord(sentence) == expected

        where:

        sentence                                    || expected
        "Kotlin rocks and is concise"               || "concise"
        "   \t  "                                   || ""
        "same size aa bb"                           || "same"
        "hyphenated-word is_longer"                 || "hyphenated-word"
        "punctuation! counts?"                      || "punctuation!"
        "\tleading and\ttrailing  spaces  "         || "trailing"
        "12345 and 678"                             || "12345"
        null                                        || ""
    }

    def "groovy: find longest word in sentence"() {
        expect:
        Day20Groovy.getLongestWord(sentence) == expected

        where:

        sentence                                || expected
        "Groovy is dynamic and elegant"         || "dynamic"
        "multi-byte ünicode chars"              || "multi-byte"
        "tabs\tand\nnewlines"                   || "newlines"
        "same same size"                        || "same"
        "edge-case: punctuation."               || "punctuation."
        ""                                      || ""
        null                                    || ""
    }
}
