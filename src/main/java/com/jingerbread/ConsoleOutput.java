package com.jingerbread;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@Slf4j
public class ConsoleOutput {

    private static final String WINDOWS_LOCALE = "Cp1251";//CP437, Cp1251, ISO8859_5

    private PrintStream printStream;

    public ConsoleOutput() throws UnsupportedEncodingException {
        String osName = System.getProperty("os.name");
        String encoding = "UTF-8";
        String consoleEncoding = System.getProperty("console.encoding");
        if (osName != null) {
            osName = osName.toLowerCase(Locale.ENGLISH);
            log.info("{} OS detected.", osName);
            if (osName.contains("windows")) {
                encoding = WINDOWS_LOCALE;
            }
        } else {
            log.error("Can't detect OS, os.name not found");
        }

        log.info("Using {} encoding for console output.", encoding);
        printStream = new PrintStream(System.out, true, encoding);
        printStream.println("Русский язык");
        System.out.println("Русский язык");
    }

    public void log(String s) {
        printStream.println(s);
    }

}
