package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 19132);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                Scanner sc = new Scanner(System.in);
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.equals("?needAnswer")) {
                        out.println(sc.nextLine());
                    } else {
                        System.out.println(inputLine);
                    }
                }
            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}