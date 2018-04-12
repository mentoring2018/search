package com.jingerbread;

import java.util.*;
import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter path to file");
        Scanner in = new Scanner(System.in);
        //  String wordsPath = in.nextLine();
        String wordsPath = "C:\\Users\\tpryn\\Desktop\\Курсовая\\words2.txt";

        List<String> loadlist = new ArrayList<String>();

        String str;

        try {
            FileInputStream fstream = new FileInputStream(wordsPath);

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream, "Cp1251"));

            while ((str = br.readLine()) != null) {
                loadlist.add(str);
            }

            if (fstream != null) {
                try {
                    fstream.close();
                } catch (IOException e) {
                    System.out.println("Can't close stream. " + e);
                }
            }


        } catch (IOException e) {
            System.out.println("Can't load text from file. Error occurred:" + e);

        }


        boolean bl = true;
        Scanner ch = new Scanner(System.in);


        do {
            System.out.println("Choose 'sort', 'search' or 'exit'");
            String choose = ch.nextLine();
            switch (choose) {
                case ("sort"):
                    System.out.println("it's sort");
                    //sorting(loadlist);
                    break;
                case ("search"):
                    System.out.println("it's search");
                    // search();
                    break;
                case ("exit"):
                    System.out.println("it's exit");
                    bl = false;
                    break;
            }
        }
        while (bl == true);



            // не понимаю, что не так с параметром
         /*  public void sorting(List<String> list)
           {
                Collections.sort(list, new Comparator<String>() {
                    //   @Override
                    public int compare(String o1, String o2) {
                        return o1.toLowerCase().compareTo(o2.toLowerCase());
                    }
                });
                // System.out.println(list);
                for (String s : list) {
                    System.out.println(s);
                }
            }*/


        }
    }


