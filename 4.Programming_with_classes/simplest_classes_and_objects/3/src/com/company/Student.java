package com.company;

//Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
//из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
//номеров групп студентов, имеющих оценки, равные только 9 или 10.
public class Student {
    private String surname;
    private String initials;
    private int groupId;
    private int[] marks;

    public Student(String surname, String initials, int groupId, int[] marks) {
        this.surname = surname;
        this.initials = initials;
        this.groupId = groupId;
        this.marks = marks;
    }

    static public void output(Student student) {
        System.out.println(student.surname + " группа " + student.groupId);
    }

    static public boolean isExcellentStudent(Student student) {
        boolean excellentMarks = true;
        for (int i : student.marks) {
            if (i < 9){
                excellentMarks = false;
            }
        }
        return excellentMarks;
    }

    public String getSurname() {
        return surname;
    }

    public String getInitials() {
        return initials;
    }

    public int getGroupId() {
        return groupId;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setGroupId(int groupId) {
        if (groupId > 0) {
            this.groupId = groupId;
        } else {
            System.out.println("Error! groupId must be greater than zero");
        }
    }

    public void setMarks(int[] marks) {
        boolean error = false;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0) {
                System.out.println("Error! marks must be greater than or equal to zero");
                error = true;
            }
        }
        if (!error) {
            this.marks = marks;
        }
    }
}
