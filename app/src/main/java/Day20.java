import java.util.Comparator;
import static java.util.Arrays.stream;

public class Day20 {
    public static String getLongestWord(String sentence) {
        if(sentence == null || sentence.isEmpty()) {
            return "";
        }

        return usingStreams(sentence);
    }

    private static String usingLoops(String sentence) {
        String[] words = sentence.split("\\s+");

        String longest = "";
        for(String word : words) {
            if(word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    private static String usingStreams(String sentence) {
        return stream(sentence.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
