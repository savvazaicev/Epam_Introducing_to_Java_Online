package com.company.string_as_object;

//Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
//Учитывать только английские буквы.
public class task_9 {
    public static void main(String[] args) {
        String str = "Yes Papa, no Papa, Johny. Мама";
        int countOfUpperCase = 0;
        int countOfLowerCase = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch) && ((ch >= 'A') && (ch <= 'Z'))) {
                countOfUpperCase++;
            }
            if (Character.isLowerCase(ch) && Character.isLetter(ch) &&
                    (((ch >= 'a') && (ch <= 'z')))) {
                countOfLowerCase++;
            }
        }
        System.out.println("Кол-во строчных (маленьких) букв: " + countOfLowerCase);
        System.out.println("Кол-во прописных (больших) букв: " + countOfUpperCase);
        System.out.println("*Русские буквы не учитываются");
    }
}
