package ru.netology.javacore;

import java.util.ArrayList;
import java.util.List;

public class Todos {


    private List<String> todos;

    public Todos() {

        todos = new ArrayList<>();
    }

    public void addTask(String task) {
        if (todos.size() < 7) ;
        todos.add(task);

    }

    public void removeTask(String task) {
        if (todos.contains(task)) {
            todos.remove(task);
        }
    }

    public String getAllTasks() {

        todos.sort(String::compareTo);

        StringBuilder buld = new StringBuilder();
        for (String todo : todos) {
            buld.append(todo);
            buld.append(" ");
        }
        return buld.toString().trim();
    }

}
