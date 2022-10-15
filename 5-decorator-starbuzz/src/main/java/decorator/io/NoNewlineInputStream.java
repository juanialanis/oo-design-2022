package decorator.io;

import java.io.*;

public class NoNewlineInputStream extends FilterInputStream {

    public NoNewlineInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        while (c == '\n') {
            c = in.read();
        }
        return c;
    }
}
