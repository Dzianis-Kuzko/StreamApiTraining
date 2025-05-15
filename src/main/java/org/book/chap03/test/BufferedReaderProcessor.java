package org.book.chap03.test;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
