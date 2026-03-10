package com.basic_spring.demo;



import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    Map<Integer, String> students = new HashMap<>();

    // GET (Idempotent)
    @GetMapping("/{id}")
    public String getStudent(@PathVariable int id) {
        return students.get(id);
    }

    // PUT (Idempotent)
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody String name) {
        students.put(id, name);
        return "Student Updated";
    }

    // DELETE (Idempotent)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.remove(id);
        return "Student Deleted";
    }

    // POST (Not Idempotent)
    @PostMapping
    public String createStudent(@RequestBody String name) {
        int id = students.size() + 1;
        students.put(id, name);
        return "Student Created with id " + id;
    }
}