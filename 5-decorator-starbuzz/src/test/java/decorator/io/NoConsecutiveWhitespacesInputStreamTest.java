package decorator.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.*;

public class NoConsecutiveWhitespacesInputStreamTest {


    String filename = "/tmp/test.txt";

    @BeforeEach
    void setUp() throws IOException {
        File file = new File(filename);
        if (!file.createNewFile()) {
            file.delete();
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        writer.write("This is    a test  file.");
        writer.close();
    }

    @Test
    public void testNoConsecutiveWhitespacesStream() throws IOException {
        InputStream input = new FileInputStream(filename);
        input = new BufferedInputStream(input);
        input = new NoConsecutiveWhitespacesInputStream(input);
        String result = "";
        int c;
        while((c = input.read()) >= 0) {
            result += (char)c;
        }
        assertThat(result).isEqualTo("This is a test file.");
    }
}
