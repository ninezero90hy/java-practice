package next.optional;

import next.optional.Computer.Soundcard;
import next.optional.Computer.USB;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerStoreTest {
    @Test
    public void getVersion() {
        String version = "pobi's usb";
        Soundcard soundcard = new Soundcard(new USB(version));
        Computer computer = new Computer(soundcard);
        Optional<String> version1 = ComputerStore.getVersion(computer);
        version1.ifPresent(v -> assertThat(v).isEqualTo(version));
    }

    @Test
    public void getVersionWhenComputerIsNull() throws Exception {
        assertThat(ComputerStore.getVersion(null)).isEqualTo(ComputerStore.UNKNOWN);
    }

    @Test
    public void getVersionWhenSoundcardIsNull() throws Exception {
        Computer computer = new Computer(null);
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN);
    }

    @Test
    public void getVersionWhenUSBIsNull() throws Exception {
        Computer computer = new Computer(new Soundcard(null));
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN);
    }

    @Test
    public void getVersionOptional() {
        String version = "pobi's usb";
        Soundcard soundcard = new Soundcard(new USB(version));
        Computer computer = new Computer(soundcard);
        assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(version);
    }

    @Test
    public void getVersionOptionalWhenComputerIsNull() throws Exception {
        assertThat(ComputerStore.getVersionOptional(null)).isEqualTo(ComputerStore.UNKNOWN);
    }

    @Test
    public void getVersionOptionalWhenSoundcardIsNull() throws Exception {
        Computer computer = new Computer(null);
        assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN);
    }

    @Test
    public void getVersionOptionalWhenUSBIsNull() throws Exception {
        Computer computer = new Computer(new Soundcard(null));
        assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN);
    }
}
