package com.jingerbread;

import java.util.*;
import java.io.*;

public class CourseWork {
    private static final String WORDS_PATH = "words.txt";
    private static final String ENCODING = "UTF-8";
    private static final List<String> loadlist = new ArrayList<String>();
    private static final Map<String, Character> hashMap = new HashMap<String, Character>();

    public static void main(String[] args) {
        InputStream fstream = null;
        String str;

        ClassLoader classLoader = CourseWork.class.getClassLoader();
        try {
            fstream = classLoader.getResourceAsStream(WORDS_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream, ENCODING));

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
            System.out.println("Choose 'sort', 'search', 'hash', 'hash search' or 'exit'");
            String choose = ch.nextLine();
            switch (choose) {
                case ("sort"):
                    System.out.println();
                    System.out.println("Sorted dictionary:");
                    sort(loadlist);
                    break;
                case ("search"):
                    System.out.println();
                    Scanner sear = new Scanner(System.in);
                    System.out.println("enter search word");
                    String searword = sear.nextLine();
                    int stpoint = 0;
                    int endpoint = loadlist.size();
                    int mpoint = loadlist.size() / 2;
                    System.out.println(search(searword, stpoint, endpoint, mpoint));
                    break;
                case ("hash"):
                    hash();
                    break;
                case ("hash search"):
                    Scanner hs = new Scanner(System.in);
                    System.out.println("enter search word");
                    String hashsearword = hs.nextLine();
                    System.out.println(hashsearch(hashsearword));
                    break;
                case ("exit"):
                    System.out.println("buy-bye");
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


    private static String search(String word, int startpoint, int endpoint, int midpoint) {
        String curword = loadlist.get(midpoint).toLowerCase();
        word = word.toLowerCase();
        int comp = curword.compareTo(word);

        if (comp == 0)
            return "this word was found";
        if (comp < 0) {
            startpoint = midpoint;
            midpoint = (endpoint - midpoint) / 2 + midpoint;
        } else {
            endpoint = midpoint;
            midpoint = (midpoint - startpoint) / 2 + startpoint;
        }
        if (midpoint == 0 && startpoint == 0)
            return search(word, startpoint, endpoint, midpoint);
        if ((endpoint - midpoint) == -1 || (midpoint - startpoint) == -1 || midpoint == startpoint) {
            return "this word wasn't found";
        }

        return search(word, startpoint, endpoint, midpoint);
    }

    private static void hash() {
        Set<Map.Entry<String, Character>> entrySet = hashMap.entrySet();
        String curword;

        for (int i = 0; i < loadlist.size(); i++) {
            curword = loadlist.get(i);
            hashMap.put(loadlist.get(i), curword.toLowerCase().charAt(0));
        }
    }


    private static String hashsearch(String word) {
        Set<Map.Entry<String, Character>> set = hashMap.entrySet();
        for (Map.Entry<String, Character> me : set) {
            if (me.getValue() == word.toLowerCase().charAt(0)) {
                if (word.equals(me.getKey()))
                    return "this word was found";
            }
        }
        return "this word wasn't found";
    }
}




