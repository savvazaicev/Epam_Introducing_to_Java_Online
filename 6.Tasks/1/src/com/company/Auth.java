package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Singleton with Double Checked Locking & volatile
public class Auth {
    private static volatile Auth instance;
    private final ArrayList<User> users = new ArrayList<>();

    public static Auth getInstance() {
        Auth localInstance = instance;
        if (localInstance == null) {
            synchronized (Auth.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Auth();
                }
            }
        }
        return localInstance;
    }

    public void readUsersData() {
        try {
            FileReader fr = new FileReader("auth.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                int index = str.indexOf(" ");
                String login = str.substring(0, index);
                String password = str.substring(index + 1, str.indexOf(" ", index + 1));
                boolean isAdmin = str.substring(str.indexOf(" ", index + 1) + 1).equals("admin");
                this.users.add(new User(login, password, isAdmin));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User login() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = in.nextLine();
        System.out.println("Введите пароль: ");
        String password = in.nextLine();
        password = Encoder.MD5Sum(password);
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        System.out.println("Ошибка! Неверный логин или пароль.");
        return null;
    }

    public void Register() {
        //ввод логина и пароля 2 раза
        Scanner in = new Scanner(System.in);
        System.out.println("Введите электронную почту: ");
        String login = in.nextLine();
        //проверка не занят ли логин
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                System.out.println("Ошибка! Пользователь с данной электронной почтой уже зарегистрирован.");
                return;
            }
        }
        //проверка является ли введённый логин адресом эл. почты
        Pattern pattern = Pattern.compile(".+@.+");
        Matcher matcher = pattern.matcher(login);
        if (!matcher.matches()) {
            System.out.println("Ошибка! Несуществующий адрес электронной почты.");
            return;
        }
        //проверка на совпадение введенных паролей
        System.out.println("Введите пароль: ");
        String firstPassword = in.nextLine();
        System.out.println("Повторите пароль: ");
        String secondPassword = in.nextLine();
        if (!firstPassword.equals(secondPassword)) {
            System.out.println("Ошибка! Введённые пароли не свопадают.");
            return;
        }
        //шифрование пароля
        String encryptedPassword = Encoder.MD5Sum(firstPassword);
        //добавление пользователя в массив users
        users.add(new User(login, encryptedPassword, false));
        //обновление файла "auth.txt"
        updateUsersData();
    }

    private void updateUsersData() {
        File inputFile = new File("auth.txt");
        File tempFile = new File("authTemp.txt");
        try {
            FileWriter fw = new FileWriter("authTemp.txt");
            for (User user :
                    users) {
                fw.write(user.getLogin() + " " + user.getPassword() + " " + "user" + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean successDelete = inputFile.delete();
        if (successDelete) {
            boolean successRename = tempFile.renameTo(inputFile);
            if (successRename) {
                System.out.println("\nФайл " + inputFile.getName() + " успешно обновлён");
            } else {
                System.out.println("\nНе удалось обновить файл " + inputFile.getName());
            }
        } else {
            System.out.println("\nНе удалось удалить файл " + inputFile.getName());
        }
    }

    static class User {
        private String login;
        private String password;
        private boolean isAdmin;

        public User(String login, String password, boolean isAdmin) {
            this.login = login;
            this.password = password;
            this.isAdmin = isAdmin;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public boolean isAdmin() {
            return isAdmin;
        }
    }
}