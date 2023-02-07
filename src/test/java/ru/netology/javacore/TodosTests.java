package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos todos = new Todos();
    Task taskTest = new Task();

    @Test
    void TestAdd() {
        todos.addTask("Прогулка");
        Assertions.assertEquals("Прогулка", todos.getAllTasks());
    }

    @BeforeEach
    void setUp() {
        String jsonText = "{ \"type\": \"ADD\", \"task\": \"Прогулка\" }";
        GsonBuilder bl = new GsonBuilder();
        Gson gson = bl.create();
        taskTest = gson.fromJson(jsonText, Task.class);
    }

    @Test
    public void testAdd2() {
        todos.addTask("Прогулка");
        todos.addTask("Магазин");
        Assertions.assertEquals("Магазин Прогулка", todos.getAllTasks());
    }

}
