package next.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.Optional.ofNullable;

public class User {

    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean matchName(final String name) {
        return this.name.equals(name);
    }

    public static boolean ageIsInRange(User user) {
        return ofNullable(user)
                .map(User::getAge)
                .filter(age -> age >= 30 && age <= 45)
                .isPresent();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
