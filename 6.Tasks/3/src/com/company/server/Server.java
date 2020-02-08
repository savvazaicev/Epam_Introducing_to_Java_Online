package com.company.server;

import java.io.*;
import java.net.ServerSocket;

public class Server {

    protected static BufferedReader in;
    protected static PrintWriter out;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(19132);
                System.out.println("Сервер запущен!");
                java.net.Socket clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    UI ui = new UI();
                    ui.authPage();
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}