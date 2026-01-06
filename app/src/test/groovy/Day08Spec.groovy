import spock.lang.Specification


/**
 * Problem:
 * Find the longest common prefix among an array of strings.
 *
 * Rules and Constraints:
 * - The common prefix must appear at the start of each string.
 * - The comparison should be case-sensitive.
 * - If there is no common prefix, return an empty string.
 * - If the input array is empty, return an empty string.
 * - An array containing a single string should return that string.
 *
 * Examples:
 * - ["flower", "flow", "flight"] → "fl"
 * - ["dog", "racecar", "car"]    → ""
 * - ["test"]                     → "test"
 * - []                           → ""
 */
class Day08Spec extends Specification {

    def "java: common prefix multiple cases"() {
        expect:
        Day08.getLongestCommonPrefix(inputList) == expected

        where:
        inputList                                    | expected
        ["flower", "flow", "flight"]                 | "fl"
        ["dog", "racecar", "car"]                    | ""
        ["interspecies", "interstellar", "interstate"] | "inters"
        ["hello"]                                    | "hello"
        []                                           | ""
        ["", "", ""]                                 | ""
        ["Flower", "flow"]                           | ""
    }
    def "kotlin common prefix various cases"() {
        expect:
        Day08Kt.getLongestCommonPrefix(inputList) == expected

        where:
        inputList                                   | expected
        ["prelude", "prevent", "preview"]           | "pre"
        ["alpha", "beta", "gamma"]                  | ""
        ["Prefix", "prefix"]                        | ""
        ["solo"]                                    | "solo"
        ["", ""]                                    | ""
    }

    def "groovy combined common prefix cases"() {
        expect:
        Day08Groovy.getLongestCommonPrefix(inputList) == expected

        where:
        inputList                                              | expected
        ["interview", "internet", "internal", "interval"]      | "inter"
        ["bat", "banana", "carrot"]                            | ""
        ["abcdef", "abc123", "abcde"]                          | "abc"
        ["repeat", "repeat", "repeat"]                         | "repeat"
        ["singleton"]                                          | "singleton"
        ["", "a", ""]                                          | ""
        ["Groovy", "groove"]                                   | ""
    }
}
