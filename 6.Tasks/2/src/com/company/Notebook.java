package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notebook {
    private ArrayList<Note> notes = new ArrayList<>();

    public void readData() throws IOException, ParseException {
        FileReader fr = new FileReader("notes.txt");
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            //чтение данных по строкам
            String topic = sc.nextLine();
            String dateString = sc.nextLine();
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse(dateString);
            String email = sc.nextLine();
            String content = sc.nextLine();
            //создание нового обьекта и его добавление
            Note note = new Note(topic, date, email, content);
            notes.add(note);
        }
        fr.close();
    }

    public void saveData() throws IOException {
        File inputFile = new File("notes.txt");
        File tempFile = new File("notesTemp.txt");
        FileWriter fw = new FileWriter("notesTemp.txt");
        for (Note i :
                notes) {
            fw.write(i.toString());
        }
        fw.close();
        boolean successDelete = inputFile.delete();
        if (successDelete) {
            boolean successRename = tempFile.renameTo(inputFile);
            if (successRename) {
                System.out.println("\nФайл " + inputFile.getName() + " успешно обновлён");
            }
        }
    }

    public void searchByTopic(String topic) {
        ArrayList<Note> sortedNotes = new ArrayList<>();
        for (Note i :
                notes) {
            if (i.getTopic().equals(topic)) {
                sortedNotes.add(i);
            }
        }
        sortedNotes = sortByDate(sortedNotes);
        for (Note i :
                sortedNotes) {
            System.out.println(i.toString());
        }
    }

    public void searchByDate(String date) {
        ArrayList<Note> sortedNotes = new ArrayList<>();
        for (Note i :
                notes) {
            if (date.equals(i.getDateAsString())) {
                sortedNotes.add(i);
            }
        }
        sortedNotes = sortByDate(sortedNotes);
        for (Note i :
                sortedNotes) {
            System.out.println(i.toString());
        }
    }

    public void searchByEmail(String email) {
        ArrayList<Note> sortedNotes = new ArrayList<>();
        for (Note i :
                notes) {
            if (i.getEmail().equals(email)) {
                sortedNotes.add(i);
            }
        }
        sortedNotes = sortByDate(sortedNotes);
        for (Note i :
                sortedNotes) {
            System.out.println(i.toString());
        }
    }

    public void searchByContent(String content) {
        ArrayList<Note> sortedNotes = new ArrayList<>();
        for (Note i :
                notes) {
            if (i.getContent().contains(content)) {
                sortedNotes.add(i);
            }
        }
        sortedNotes = sortByDate(sortedNotes);
        for (Note i :
                sortedNotes) {
            System.out.println(i.toString());
        }
    }

    public void search(String topic, String date) {
        ArrayList<Note> sortedNotes = new ArrayList<>();
        for (Note i :
                notes) {
            if (i.getTopic().equals(topic) && i.getDateAsString().equals(date)) {
                sortedNotes.add(i);
            }
        }
        sortedNotes = sortByDate(sortedNotes);
        for (Note i :
                sortedNotes) {
            System.out.println(i.toString());
        }
    }

    public ArrayList<Note> sortByDate(ArrayList<Note> sortedNotes) {
        for (int i = 0; i < sortedNotes.size() - 1; i++) {
            Date firstDate = sortedNotes.get(i).getDate();
            Date secondDate = sortedNotes.get(i + 1).getDate();
            if (firstDate.before(secondDate)) {
                sortedNotes.add(i, sortedNotes.get(i + 1));
                sortedNotes.remove(i + 2);
            }
        }
        return sortedNotes;
    }

    public void add() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название: ");
        String topic = in.nextLine().trim();
        System.out.println("Введите дату в формате дд.мм.гггг: ");
        Pattern p = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        String dateString = in.nextLine().trim();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse(dateString);
        System.out.println("Введите почту: ");
        String email = in.nextLine().trim();
        Pattern pattern = Pattern.compile(".+@.+");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Ошибка! Несуществующий адрес электронной почты.");
            return;
        }
        System.out.println("Введите содержимое: ");
        String content = in.nextLine().trim();
        Note note = new Note(topic, date, email, content);
        notes.add(note);
    }
}