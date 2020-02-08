package com.company;

import java.io.IOException;
import java.util.Scanner;

public class UI {
    private final Library library = Library.getInstance();

    public UI() {
    }

    void authPage() throws IOException {
        while (true) {
            System.out.println("Введите номер операции:\n1.Войти\n2.Зарегистрироваться\n3.Выйти из программы");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            Auth auth = Auth.getInstance();
            auth.readUsersData();
            switch (input) {
                case 1:
                    Auth.User user = null;
                    while (user == null) {
                        user = auth.login();
                    }
                    if (user.isAdmin()) {
                        adminUI();
                    } else {
                        userUI();
                    }
                    break;
                case 2:
                    auth.Register();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ошибка! Выход за диапазон значений.");
            }
        }
    }

    private void userUI() {
        while (true) {
            System.out.println("\n1.Просмотреть каталог\n2.Найти книгу\n3.Выйти");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            switch (input) {
                case 1:
                    library.browse();
                    break;
                case 2:
                    library.searchBook();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ошибка! Выход за диапазон значений.");
            }
        }
    }

    private void adminUI() {
        while (true) {
            System.out.println("\n1.Добавить книгу\n2.Удалить книгу\n3.Выйти");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            switch (input) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.deleteBook();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ошибка! Выход за диапазон значений.");
            }
        }
    }
}