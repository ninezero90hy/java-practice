package next.optional;

import next.optional.Computer.Soundcard;
import next.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {

    public static final String UNKNOWN = "UNKNOWN";

    public static String getVersion(Computer computer) {
        return Optional.ofNullable(computer)
                .map(Computer::getSoundcard)
                .map(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse(UNKNOWN);
    }

    public static String getVersionOptional(Computer computer) {
        return null;
    }
}
