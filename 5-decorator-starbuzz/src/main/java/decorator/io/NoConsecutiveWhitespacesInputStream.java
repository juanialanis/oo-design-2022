package decorator.io;

import java.io.*;

public class NoConsecutiveWhitespacesInputStream extends FilterInputStream {

    public NoConsecutiveWhitespacesInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        boolean whitespaces = false;
        while (c == ' ') {
            whitespaces = true;
            c = in.read();
        }
        if (whitespaces)
            return ' ';
        return c;
    }
}
