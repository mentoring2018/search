package com.jingerbread;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class DictionaryLoader {

    private final static String wordsPath = "words.txt";

    @Getter
    private List<String> words = new LinkedList<>();

    public DictionaryLoader() {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(wordsPath).getPath();
        File wordsFile = new File(path);
        if (!wordsFile.exists()) {
            log.error("No file {} found.", wordsPath);
            return;
        }
        try {
            words = Files.readAllLines(Paths.get(wordsFile.getAbsolutePath()));
        } catch (IOException e) {
            log.error("Can't read load words from path {}", wordsPath, e);
        }
    }
}
