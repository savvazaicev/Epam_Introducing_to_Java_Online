package com.company.string_as_object;

//Вводится строка слов, разделенных пробелами.
//Найти самое длинное слово и вывести его на экран.
//Случай, когда самых длинных слов может быть несколько, не обрабатывать.
public class task_8 {
    public static void main(String[] args) {
        String str = "Мама ела вкусное мыло";
        str.trim();
        int count = 0;
        int maxCount = 0;
        int startIndex = 0;
        int endIndex = 0;
        int spaceIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || i == str.length() - 1) {
                if (count > maxCount) {
                    maxCount = count;
                    if (i == str.length() - 1) {
                        endIndex = i + 1;
                    } else {
                        endIndex = i;
                    }
                    startIndex = spaceIndex;
                }
                count = 0;
            } else {
                count++;
            }
            if (str.charAt(i) == ' ') {
                spaceIndex = i + 1;
            }
        }
        System.out.println(str.substring(startIndex, endIndex));
    }
}
