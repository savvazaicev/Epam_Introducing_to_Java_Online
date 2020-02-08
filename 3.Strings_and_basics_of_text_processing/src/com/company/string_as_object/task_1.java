package com.company.string_as_object;

//Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
public class task_1 {
    public static void main(String[] args) {
        String str = "  50 плюс   50 равно  100  . ";
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                count++;
            } else {
                if (count > maxCount){
                    maxCount = count;
                }
                count = 0;
            }
        }
        System.out.println(maxCount);
    }
}
