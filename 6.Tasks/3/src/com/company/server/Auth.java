package com.company.server;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.server.Server.in;
import static com.company.server.Server.out;

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
        try {
            out.println("Введите логин: ");
            out.println("?needAnswer");
            String login = in.readLine();
            out.println("Введите пароль: ");
            out.println("?needAnswer");
            String password = in.readLine();
            password = Encoder.MD5Sum(password);
            for (User user : users) {
                if (password != null && login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                    return user;
                }
            }
            out.println("Ошибка! Неверный логин или пароль.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Register() {
        try {
            out.println("Введите электронную почту: ");
            out.println("?needAnswer");
            String login = in.readLine();
            for (User user : users) {
                if (login.equals(user.getLogin())) {
                    out.println("Ошибка! Пользователь с данной электронной почтой уже зарегистрирован.");
                    return;
                }
            }
            Pattern pattern = Pattern.compile(".+@.+");
            Matcher matcher = pattern.matcher(login);
            if (!matcher.matches()) {
                out.println("Ошибка! Несуществующий адрес электронной почты.");
                return;
            }
            out.println("Введите пароль: ");
            out.println("?needAnswer");
            String firstPassword = in.readLine();
            out.println("Повторите пароль: ");
            out.println("?needAnswer");
            String secondPassword = in.readLine();
            if (!firstPassword.equals(secondPassword)) {
                out.println("Ошибка! Введённые пароли не свопадают.");
                return;
            }
            String encryptedPassword = Encoder.MD5Sum(firstPassword);
            users.add(new User(login, encryptedPassword, false));
            updateUsersData();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                    out.println("\nФайл " + inputFile.getName() + " успешно обновлён");
            } else {
                out.println("\nНе удалось обновить файл " + inputFile.getName());
            }
        } else {
            out.println("\nНе удалось удалить файл " + inputFile.getName());
        }
    }

    static class User {
        private final String login;
        private final String password;
        private final boolean isAdmin;

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