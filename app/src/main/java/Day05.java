public class Day05 {
    public static String getFirstNonRepeatingChar(String s) {
        return usingLoops(s);
    }

    private static String usingLoops(String s) {
        for(char c1 : s.toCharArray())  {
            int foundCnt = 0;  //the character should appear only once

            for(char c2 : s.toCharArray()) {
                if (c1 == c2) {
                    foundCnt++;
                }
            }

            if(foundCnt == 1) {
                return String.valueOf(c1);
            }
        }

        return "";
    }

    private static String usingStreams(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .filter(c1 -> s.chars().filter(c2 -> c2 == c1).count() == 1)
                .map(String::valueOf)
                .findFirst()
                .orElse("");
    }


}
