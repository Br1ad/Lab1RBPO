package com.example.Lab1;

public class Student {
    private Long id;
    private String name;
    private String group;

    // Конструктор по умолчанию (нужен для JSON)
    public Student() {}

    // Конструктор со всеми полями
    public Student(Long id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }
}