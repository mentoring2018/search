package com.jingerbread;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class DictionaryLoader {

    private final static String wordsPath = "words.txt";

    @Getter
    private List<String> words;

    public DictionaryLoader() {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream in = classLoader.getResourceAsStream(wordsPath)) {
            words = new BufferedReader(new InputStreamReader(in,
                    StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error occurred", e);
        }
    }
}
