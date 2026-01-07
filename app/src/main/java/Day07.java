import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day07 {
    public static String compress(String s) {
       return usingStreams(s);
    }

    private static String usingLoops(String s) {
        if(s.isEmpty()) {
            return s;
        }

        StringBuilder compressedS = new StringBuilder();

        char last = s.charAt(0);
        int count = 1;

        for(int i = 1; i < s.length() ; i++) {
            if(last == s.charAt(i)) {
                count++;
            } else {
                compressedS.append(last).append(count);
                last = s.charAt(i);
                count = 1;
            }
        }

        //capture the last part of the string
        compressedS.append(last).append(count);

        return compressedS.toString();
    }

    // Stream-based implementation of run-length encoding using a stateful collector
    // classic loop approach better choice due to complexity of stateful element
    private static String usingStreams(String s) {
        if (s.isEmpty()) return s;

        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        ArrayList<int[]>::new,
                        (list, c) -> {
                            if (list.isEmpty() || list.get(list.size() - 1)[0] != c)
                                list.add(new int[]{c, 1});
                            else
                                list.get(list.size() - 1)[1]++;
                        },
                        List::addAll
                ).stream()
                .map(a -> "" + (char) a[0] + a[1])
                .collect(Collectors.joining());
    }
}
