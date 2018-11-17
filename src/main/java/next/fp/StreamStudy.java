package next.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamStudy {

    private static final String PATH_WAR_AND_PEACE_TXT = "src/main/resources/fp/war-and-peace.txt";
    private static final int WORD_RANK_TOP_100 = 100;

    public static long countWords() throws IOException {
        final String contents = new String(Files.readAllBytes(Paths.get(PATH_WAR_AND_PEACE_TXT)), StandardCharsets.UTF_8);
        final List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        return words.stream().filter(w -> w.length() > 12).count();
    }

    public static void printLongestWordTop100() throws IOException {
        final String contents = new String(Files.readAllBytes(Paths.get(PATH_WAR_AND_PEACE_TXT)), StandardCharsets.UTF_8);
        final List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        words.stream()
                .filter(StreamStudy::NotEmpty)
                .sorted(StreamStudy::compare)
                .distinct()
                .limit(WORD_RANK_TOP_100)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return 0;
    }

    private static int compare(final String word1, final String word2) {
        return word2.length() - word1.length();
    }

    private static boolean NotEmpty(String w) {
        return !w.isEmpty();
    }
}