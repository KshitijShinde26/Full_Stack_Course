package com.basic_spring.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;
    @NotBlank(message = "Email is required")
    private String email;
    private String gender;

    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 99, message = "Maximum age is 99")
    private int age;

    @NotNull(message = "Date of Birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Password is required")
    private String password;

    private String photo = "default.png";

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }
}