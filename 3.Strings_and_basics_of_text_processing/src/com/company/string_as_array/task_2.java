package com.company.string_as_array;

import java.util.ArrayList;

//Замените в строке все вхождения 'word' на 'letter'.
public class task_2 {
    public static void main(String[] args) {
        String str = "I'm gonna say the \"N\" word.";
        ArrayList<Integer> positions = findWord(str);
        char[] letters = new char[str.length() + positions.size() * 2];
        char[] letter = {'l', 'e', 't', 't', 'e', 'r'};
        int additionalLetters = 0;
        for (int i = 0; i < str.length(); i++) {
            if (positions.contains(i)) {
                int index = 0;
                for (int j = i + additionalLetters; j < i + additionalLetters + 6; j++) {
                    letters[j] = letter[index];
                    index++;
                }
                additionalLetters += 2;
                i += 3;
            } else {
                letters[i + additionalLetters] = str.charAt(i);
            }
        }
        String newStr = String.valueOf(letters);
        System.out.println(newStr);
    }

    private static ArrayList<Integer> findWord(String str) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'w' && str.charAt(i + 1) == 'o' &&
                    str.charAt(i + 2) == 'r' && str.charAt(i + 3) == 'd') {
                positions.add(i);
            }
        }
        return positions;
    }
}