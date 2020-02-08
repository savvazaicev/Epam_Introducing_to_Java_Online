package com.company.string_as_object;

import java.util.ArrayList;

//В строке вставить после каждого символа 'a' символ 'b'.
public class task_2 {
    public static void main(String[] args) {
        String str = "Мама мыла раму";
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'а') {
                letters.add(str.charAt(i));
                letters.add('b');
            } else {
                letters.add(str.charAt(i));
            }
        }
        char[] charStr = new char[letters.size()];
        for (int i = 0; i < letters.size(); i++) {
            charStr[i] = letters.get(i);
        }
        str = String.valueOf(charStr);
        System.out.println(str);
    }
}
