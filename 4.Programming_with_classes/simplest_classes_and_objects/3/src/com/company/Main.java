package com.company;

//Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
//из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
//номеров групп студентов, имеющих оценки, равные только 9 или 10.
public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Зайцев", "С.Ю.", 1, new int[]{6, 7, 8, 9, 10});
        Student student2 = new Student("Иванов", "А.К.", 2, new int[]{10, 9, 10, 9, 10});
        Student student3 = new Student("Петров", "Б.Л.", 3, new int[]{6, 7, 8, 9, 10});
        Student student4 = new Student("Сидоров", "В.М.", 4, new int[]{6, 7, 8, 9, 10});
        Student student5 = new Student("Неформалов", "Г.О.", 5, new int[]{10, 9, 10, 9, 10});
        Student student6 = new Student("Дальних", "Д.П.", 6, new int[]{6, 7, 8, 9, 10});
        Student student7 = new Student("Маск", "У.Р.", 7, new int[]{6, 7, 8, 9, 10});
        Student student8 = new Student("Трамп", "Ж.С.", 8, new int[]{6, 7, 8, 9, 10});
        Student student9 = new Student("Барак", "З.Т.", 9, new int[]{6, 7, 8, 9, 10});
        Student student10 = new Student("Кеннеди", "И.У.", 10, new int[]{6, 7, 8, 9, 10});
        Student[] students = new Student[]{student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10};
        for (Student i : students) {
            if (Student.isExcellentStudent(i)) {
                Student.output(i);
            }
        }
    }
}
