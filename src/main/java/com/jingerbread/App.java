package com.jingerbread;

import com.jingerbread.hashmap.CustomHashMap;
import com.jingerbread.hashmap.Wrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

@Slf4j
public class App {

    public static void main( String[] args ) {
        DictionaryLoader dictionaryLoader = new DictionaryLoader();
        List<String> loadedWords = dictionaryLoader.getWords();
        Function<String, Integer> hashFunction = s -> s.codePointAt(0);
        CustomHashMap<Wrapper> hashMap = new CustomHashMap<>(32);

        for (String w : loadedWords) {
            Wrapper wrapper = new Wrapper(w, hashFunction);
            hashMap.put(wrapper);
        }


        Scanner in = new Scanner(System.in);
        boolean end;
        do {
            log.info("Choose either get sorted dictionary - enter 'sort' or search for the word - enter 'search'");
            String choose = in.nextLine();
            switch (choose.toLowerCase()) {
                case "sort":
                    sort(loadedWords);
                    break;
                case "search":
                    search(hashMap, hashFunction);
                    break;
                default:
                    log.error("Unsupported operation. exit");
                    return;
            }
            log.info("If you want to exit: enter yes");
            String exit = in.nextLine();
            end = exit.equalsIgnoreCase("Yes");
        } while (!end);
    }

    private static void sort(List<String> loaded) {
        Collections.sort(loaded);
        log.info("Sorted:\n{}", loaded);
    }

    private static void search(CustomHashMap<Wrapper> hashMap, Function<String, Integer> hashFunction) {
        log.info("Enter word to search");
        String word = new Scanner(System.in).nextLine();
        if (hashMap.get(new Wrapper(word, hashFunction)).isPresent())  {
            log.info("Found: {}", word);
        } else {
            log.info("No results");
        }
    }

    private static void showHelpInfo() {
        log.info("Show help info");
    }
}
