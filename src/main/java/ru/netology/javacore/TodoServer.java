package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    public int port;
    public Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(8989)) {
            System.out.println("Starting server at " + port + "...");
            while (true) {
                try (
                        Socket socket = server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    String jsonT = in.readLine();
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    Task task2 = gson.fromJson(jsonT, Task.class);

                    switch (task2.type) {
                        case "ADD" : todos.addTask(task2.task);
                        break;
                        case "REMOVE" : todos.removeTask(task2.task);
                        break;

                    }

                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Server is not start");
            e.printStackTrace();
        }
    }


}
