package org.example.task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    //Создаем карту
    private HashMap<String, List<String>> data = new HashMap<>();

    public void add(String lastName, String phone) {
        if (!data.containsKey(lastName)) {
            data.put(lastName, new ArrayList<>());
        }
        data.get(lastName).add(phone);
    }

    public List<String> get(String lastName) {
        return data.getOrDefault(lastName, new ArrayList<>());
    }
}
