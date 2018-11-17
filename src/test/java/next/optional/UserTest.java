package next.optional;

import static next.optional.User.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UserTest {

    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertThat(ageIsInRange(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange(new User("crong", null))).isFalse();
        assertThat(ageIsInRange(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange(null)).isFalse();
    }

}
