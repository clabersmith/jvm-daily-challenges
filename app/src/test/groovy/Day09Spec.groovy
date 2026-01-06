import spock.lang.Specification

/**
 * Problem:
 * Capitalize the first letter of each word in a given sentence.
 *
 * Rules and Constraints:
 * - A word is defined as a sequence of characters separated by one or more spaces.
 * - Only the first character of each word should be capitalized.
 * - All other characters in each word should remain unchanged.
 * - Leading, trailing, and multiple spaces between words should be preserved.
 * - An empty string should return an empty string.
 *
 * Examples:
 * - "hello world"                  → "Hello World"
 * - "java   is   fun"               → "Java   Is   Fun"
 * - "welcome to the 2025 conference" → "Welcome To The 2025 Conference"
 * - ""                              → ""
 */
class Day09Spec extends Specification {

    def "java: capitalize first letter - various cases"() {
        expect:
        Day09.capitalizeFirst(input) == expected

        where:
        input                                    || expected
        "hello world"                            || "Hello World"
        "  hello   world  "                      || "Hello World"
        "123abc !foo bar"                        || "123abc !foo Bar"
        "To a t"                                 || "To A T"
        "welcome to the 2025 conference"         || "Welcome To The 2025 Conference"
        ""                                       || ""
    }

    def "kotlin: capitalize first letter - various cases"() {
        expect:
        Day09Kt.capitalizeFirst(input) == expected

        where:
        input                                    || expected
        "kotlin is  fun"                         || "Kotlin Is Fun"
        "  multiple   spaces  between "          || "Multiple Spaces Between"
        "mIXed caSe"                             || "MIXed CaSe"
        "#foo 99bar baz"                         || "#foo 99bar Baz"
        "2025 trends"                            || "2025 Trends"
        ""                                       || ""
    }

    def "groovy: capitalize first letter - various cases"() {
        expect:
        Day09Groovy.capitalizeFirst(input) == expected

        where:
        input                        || expected
        "greetings cosmos"           || "Greetings Cosmos"
        "  trim   and   join  "      || "Trim And Join"
        "42meaning !bang echo"       || "42meaning !bang Echo"
        ""                           || ""
    }
}
