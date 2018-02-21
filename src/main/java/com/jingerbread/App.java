package com.jingerbread;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class App {

    public static void main( String[] args ) {
        DictionaryLoader dictionaryLoader = new DictionaryLoader();
        List<String> loadedWords = dictionaryLoader.getWords();

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
                    search(loadedWords);
                    break;
                default:
                    log.error("unsupported operation. exit");
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

    private static void search(List<String> loaded) {

    }

    private static void showHelpInfo() {
        log.info("Show help info");
    }
}
