package com.company.string_as_object;

//Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
//Например, если было введено "abc cde def", то должно быть выведено "abcdef".
public class task_7 {
    public static void main(String[] args) {
        String str = "Мама мыла раму";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) || str.charAt(j) == ' ') {
                    String secondStrPart = str.substring(j + 1);
                    str = str.substring(0, j);
                    str = str.concat(secondStrPart);
                }
            }
        }
        System.out.println(str);
    }
}
