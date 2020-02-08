package com.company.string_as_array;

//Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
//Крайние пробелы в строке удалить.
class task_5 {
    public static void main(String[] args) {
        String str = "  50 плюс   50 равно  100  . ";
        str = str.trim();
        //удаление повторных пробелов
        while (str.contains("  ")) {
            str = str.replaceAll("  ", " ");
        }
        //удаление пробелов перед знаками пунктуации
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && (str.charAt(i + 1) == '.' ||
                    str.charAt(i + 1) == ',' || str.charAt(i + 1) == ':' ||
                    str.charAt(i + 1) == '!' || str.charAt(i + 1) == '?')) {
                String secondStrPart = str.substring(i + 1);
                str = str.substring(0, i);
                str = str.concat(secondStrPart);
            }
        }
        System.out.println(str);
    }
}