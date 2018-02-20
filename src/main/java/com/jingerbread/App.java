package com.jingerbread;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class App {

    public static void main( String[] args ) {
        DictionaryLoader dictionaryLoader = new DictionaryLoader();
        Scanner in = new Scanner(System.in);
        boolean end;
        do {
            log.info("Choose either get sorted dictionary or search");
            String choose = in.nextLine();
            switch (choose.toLowerCase()) {
                case "sort":
                    sort();
                    break;
                case "search":
                    search();
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

    private static void sort() {

    }

    private static void search() {

    }

    private static void showHelpInfo() {
        log.info("Show help info");
    }
}
