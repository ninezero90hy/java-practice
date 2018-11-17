package next.fp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    private List<Integer> numbers;

    @Before
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countWords() throws Exception {
        long result = Stream.countWords();
        System.out.println("result : " + result);
    }

    @Test
    public void printLongestWordTop100() throws Exception {
        Stream.printLongestWordTop100();
    }

    @Test
    public void map() {
        List<Integer> doubleNumbers = Stream.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @Test
    public void sumAll() {
        long sum = Stream.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumOverThreeAndDouble() {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = Stream.sumOverThreeAndDouble(numbers, number -> number > 3);
        assertThat(sum).isEqualTo(36);
    }
}
