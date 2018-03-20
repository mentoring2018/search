package com.jingerbread;

import java.util.*;
import java.io.*;

public class Test2 {
        public static void main(String[] args) {

            List<String> list = new ArrayList<String>();

            String str;

            try {
                FileInputStream fstream = new FileInputStream("C:\\Users\\tpryn\\Desktop\\Курсовая\\words2.txt");
                BufferedReader  br = new BufferedReader(new InputStreamReader(fstream, "Cp1251"));

                while ((str = br.readLine()) != null) {
                    list.add(str);
                }

            } catch (IOException e) {
                System.out.println("Ошибка");
            }



            // как сделать, чтобы слова с маленькой буквы и слова с большой буквы сортировались вместе?
            Collections.sort(list, new Comparator<String>() {
             //   @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            // System.out.println(list);
            for (String s: list) {
                System.out.println(s);
            }
        }
    }


