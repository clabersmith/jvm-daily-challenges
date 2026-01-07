import java.util.HashMap;
import java.util.Map;

public class Day06 {
    public static boolean isAnagrams(String s1, String s2) {
        return usingLoops(s1, s2);
    }

    private static boolean usingLoops(String s1, String s2) {
        Map<Character, Integer> mapS1= new HashMap<>();
        Map<Character, Integer> mapS2= new HashMap<>();

        char[] charArray1 = s1.toLowerCase().replaceAll("\\s+", "").toCharArray();
        for(Character c: charArray1) {
            mapS1.put(c,mapS1.getOrDefault(c,0) + 1);
        }

        char[] charArray2 = s2.toLowerCase().replaceAll("\\s+", "").toCharArray();
        for(Character c: charArray2) {
            mapS2.put(c,mapS2.getOrDefault(c,0) + 1);
        }

        return mapS1.equals(mapS2);
    }

    private static boolean usingStreams(String s1, String s2) {
        Map<Character, Long> mapS1 = s1.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.counting()));

        Map<Character, Long> mapS2 = s2.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.counting()));

        return mapS1.equals(mapS2);
    }
}
