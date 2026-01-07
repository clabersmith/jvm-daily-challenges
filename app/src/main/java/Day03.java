public class Day03 {
    public static long countVowels(String s) {
        return s.toLowerCase()
                .chars()
                .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                .count();
    }
}
