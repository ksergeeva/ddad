package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clients {


    private static final int PORT = 8989;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket client = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            String textJ = "{ \"type\": \"ADD\", \"task\": \"Прогулка\" }";
            // String textJ3 = "{ \"type\": \"ADD\", \"task\": \"Магазин\" }";
            //String textJ2 = "{ \"type\": \"REMOVE\", \"task\": \"Прогулка\" }";
            out.println(textJ);
            //  out.println(textJ2);
            //  out.println(textJ3);

            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}