package org.solvd.school.model;

import java.util.List;

public class Subject {

    private Long id;
    private String name;
    private String faculty;
    private List<Teacher> teachers;

    public Subject(Long id, String name, String faculty, List<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", teachers=" + teachers +
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
