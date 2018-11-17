package next.optional;

import next.optional.Computer.Soundcard;
import next.optional.Computer.USB;

import java.util.Optional;

import static java.util.Optional.of;

public class ComputerStore {

    public static final String UNKNOWN = "UNKNOWN";

    public static Optional<String> getVersion(Computer computer) {
        return of(Optional.ofNullable(computer)
                .flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUsb)
                .flatMap(USB::getVersion)
                .orElse(UNKNOWN));
    }

    public static String getVersionOptional(Computer computer) {
        return null;
    }
}
