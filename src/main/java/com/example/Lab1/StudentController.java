package com.example.Lab1;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1L, "Иван Иванов", "БАС2301"),
            new Student(2L, "Крут Крутов", "БАС2302")
    ));

    // 1. GET: Получить всех студентов (http://localhost:8080/api/students)
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // 2. GET: Получить одного студента по ID (http://localhost:8080/api/students/1)
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 3. POST: Добавить нового студента
    @PostMapping
    public Student createStudent(@RequestBody Student newStudent) {
        students.add(newStudent);
        return newStudent; // Возвращаем созданного студента
    }

    // 4. DELETE: Удалить студента по ID (http://localhost:8080/api/students/1)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean removed = students.removeIf(s -> s.getId().equals(id));
        return removed ? "Студент успешно удален" : "Студент не найден";
    }
}
