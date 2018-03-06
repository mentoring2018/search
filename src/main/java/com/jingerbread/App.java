package com.jingerbread;

import com.jingerbread.hashmap.CustomHashMap;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

@Slf4j
public class App {

    private static ConsoleOutput console;

    public static void main( String[] args ) {

        try {
            console = new ConsoleOutput();
            DictionaryLoader dictionaryLoader = new DictionaryLoader();

            List<String> loadedWords = dictionaryLoader.getWords();
            Function<String, Integer> hashFunction = s -> s.codePointAt(0);
            CustomHashMap<String> hashMap = new CustomHashMap<>(32, hashFunction);
            for (String w : loadedWords) {
                hashMap.put(w);
            }

            Scanner in = new Scanner(System.in);
            do {
                log.info("Choose either get sorted dictionary - enter 'sort' or search for the word - enter 'search'");
                String choose = in.nextLine();
                switch (choose.toLowerCase()) {
                    case "sort":
                        sort(loadedWords);
                        break;
                    case "search":
                        search(hashMap);
                        break;
                    default:
                        log.error("Unsupported operation. exit");
                        return;
                }
            } while (true);

        } catch (UnsupportedEncodingException e) {
            log.error("Can't set up console output. exit.",e);
        }
    }

    private static void sort(List<String> loaded) {
        Collections.sort(loaded);
        console.log("Sorted:\n" + loaded);
    }

    private static void search(CustomHashMap<String> hashMap) throws UnsupportedEncodingException {
        log.info("Enter word to search");
        Scanner scanner = new Scanner(System.in, console.getEncoding());
        if (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (hashMap.get(word).isPresent()) {
                log.info("Found: {}", word);
            } else {
                log.info("No results");
            }
        }
    }

    private static void showHelpInfo() {
        log.info("Show help info");
    }
}
