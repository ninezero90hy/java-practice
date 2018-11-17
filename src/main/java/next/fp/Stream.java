package next.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Stream {

    private static final String PATH_WAR_AND_PEACE_TXT = "src/main/resources/fp/war-and-peace.txt";
    private static final int WORD_RANK_TOP_100 = 100;

    public static long countWords() throws IOException {
        return Arrays.stream(new String(Files.readAllBytes(Paths.get(PATH_WAR_AND_PEACE_TXT)), StandardCharsets.UTF_8).split("[\\P{L}]+"))
                .filter(w -> w.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        Arrays.stream(new String(Files.readAllBytes(Paths.get(PATH_WAR_AND_PEACE_TXT)), StandardCharsets.UTF_8).split("[\\P{L}]+"))
                .filter(Stream::filterWordLengthTwelve)
                .sorted(Stream::compare)
                .distinct()
                .limit(WORD_RANK_TOP_100)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * 2)
                .collect(toList());
    }

    public static long sumAll(final List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Math::addExact);
    }

    public static long sumOverThreeAndDouble(final List<Integer> numbers, final Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .map(number -> number * 2)
                .reduce(0, Math::addExact);
    }

    private static int compare(final String x, final String y) {
        return y.length() - x.length();
    }

    private static boolean filterWordLengthTwelve(final String word) {
        return word.length() > 12;
    }

}