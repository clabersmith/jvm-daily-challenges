import java.util.Arrays;
import java.util.stream.Collectors;

public class Day09 {
    public static String capitalizeFirst(String in) {
        if(in.isEmpty()) return "";

        return asStream(in);
    }

    private static String asLoop(String in) {
        String[] tokens = in.trim().split("\\s+");
        StringBuilder out = new StringBuilder();

        for(String token : tokens) {
            out.append(token.substring(0, 1).toUpperCase())
                    .append(token.substring(1))
                    .append(" ");
        }

        return out.substring(0, out.length() - 1);
    }

    private static String asStream(String in) {
        return Arrays.stream(in.trim().split("\\s+"))
                .map(it -> it.substring(0,1).toUpperCase() + it.substring(1))
                .collect(Collectors.joining(" "));
    }
}
