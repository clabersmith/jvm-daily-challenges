import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day04 {
    public static String removeDuplicates (String s) {
        return usingStreams(s);
    }

    private static String usingStreams(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private static String usingLoops(String s) {
        Map<Character, Boolean> foundMap = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        for(Character c :  s.toCharArray()) {
            if(!foundMap.containsKey(c)) {
                foundMap.put(c, true);
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
