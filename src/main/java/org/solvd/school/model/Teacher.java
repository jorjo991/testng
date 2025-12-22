package org.solvd.school.model;

import java.util.Objects;

public class Teacher {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private Long salary;

    public Teacher(Long id, String name, String surname, String email, Integer age, Long salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    public Teacher() {

    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(name, teacher.name) && Objects.equals(surname, teacher.surname) && Objects.equals(email, teacher.email) && Objects.equals(age, teacher.age) && Objects.equals(salary, teacher.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, age, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", Salary=" + salary +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
