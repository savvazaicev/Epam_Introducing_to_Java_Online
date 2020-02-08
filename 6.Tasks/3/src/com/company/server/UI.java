package com.company.server;

import java.io.IOException;

import static com.company.server.Server.in;
import static com.company.server.Server.out;

public class UI {
    private static final Archive archive = Archive.getInstance();

    public UI() {
    }

    void authPage() {
        while (true) {
            try {
                out.println("Введите номер операции: 1.Войти 2.Зарегистрироваться 3.Выйти из программы");
                out.println("?needAnswer");
                int input = Integer.parseInt(in.readLine());
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
                        out.println("Ошибка! Выход за диапазон значений.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void userUI() {
        while (true) {
            try {
                out.println("\n1.Просмотреть дела 2.Выйти");
                out.println("?needAnswer");
                int input = Integer.parseInt(in.readLine());
                switch (input) {
                    case 1:
                        archive.viewDossiers();
                        break;
                    case 2:
                        return;
                    default:
                        out.println("Ошибка! Выход за диапазон значений.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void adminUI() {
        while (true) {
            try {
                out.println("\n1.Просмотреть дела 2.Изменить дело 3.Создать новое дело 4.Удалить дело 5.Выйти");
                out.println("?needAnswer");
                int input = Integer.parseInt(in.readLine());
                switch (input) {
                    case 1:
                        archive.viewDossiers();
                        break;
                    case 2:
                        archive.changeDossier();
                        break;
                    case 3:
                        archive.addDossier();
                        break;
                    case 4:
                        archive.deleteDossier();
                        break;
                    case 5:
                        return;
                    default:
                        out.println("Ошибка! Выход за диапазон значений.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}