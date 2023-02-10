package ru.netology.javacore;

import java.util.ArrayList;
import java.util.List;

public class Todos {


    private List<String> todos;
    protected int i = 7;

    public Todos() {

        todos = new ArrayList<>();
    }

    public void addTask(String task) {
        if (todos.size() < i) {
            todos.add(task);
        }
    }

    public void removeTask(String task) {
        todos.remove(task);

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
