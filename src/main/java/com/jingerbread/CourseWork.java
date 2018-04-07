package com.jingerbread;

import java.util.*;
import java.io.*;

public class CourseWork {
    public static void main(String[] args) {
       // List<String> loadlist = null;

        String wordsPath = "words.txt";
        String encoding = "Cp1251";
        InputStream fstream = null;
        List<String> loadlist = new ArrayList<String>();
        String str;

      // как исправить ошибку NullPointerException?
        ClassLoader classLoader = CourseWork.class.getClass().getClassLoader();
        try {
            fstream = classLoader.getResourceAsStream(wordsPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream, encoding));

            while ((str = br.readLine()) != null) {
                loadlist.add(str);
            }
        } catch (IOException e) {
            System.out.println("Can't load text from file. Error occurred:" + e);
        } finally {
            if (fstream != null) {
                try {
                    fstream.close();
                } catch (IOException e) {
                    System.out.println("Can't close stream. " + e);
                }
            }
        }

        boolean bl = true;
        Scanner ch = new Scanner(System.in);
        do {
            System.out.println("Choose 'sort', 'search' or 'exit'");
            String choose = ch.nextLine();
            switch (choose) {
                case ("sort"):
                    System.out.println("it's sort");
                    sort(loadlist);
                    break;
                case ("search"):
                    System.out.println("it's search");
                    search(loadlist);
                    break;
                case ("exit"):
                    System.out.println("it's exit");
                    bl = false;
                    break;
            }
        }
        while (bl == true);

    }

    private static void sort(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

    // пока недоработан
    private static void search(List<String> list) {
        Scanner sear = new Scanner(System.in);
        System.out.println("enter search word");
        String searword = sear.nextLine();
        int midpoint = list.size() / 2;
        do {
            int comp = list.get(midpoint).compareTo(searword);
            if (comp == 0)
                System.out.println("this word was found");
            if (comp > 0)
                midpoint = midpoint / 2;
            else
                midpoint = midpoint + midpoint / 2;
            if (midpoint == 0 || midpoint != list.size())
                System.out.println("this word wasn't found");
        } while (midpoint != 1 || midpoint != list.size());
    }
}



