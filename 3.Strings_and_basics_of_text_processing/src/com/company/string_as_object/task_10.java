package com.company.string_as_object;

//Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
//восклицательным или вопросительным знаком. Определить количество предложений в строке X.
public class task_10 {
    public static void main(String[] args) {
        String str = "Снег идёт? Нет! Понятно.";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '.' || ch == '?' || ch == '!') {
                count++;
            }
        }
        System.out.println(count);
    }
}
