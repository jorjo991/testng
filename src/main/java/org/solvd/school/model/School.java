package org.solvd.school.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {

    private Long id;
    private String name;
    private Integer number;
    private Boolean publicSchool;
    private List<ClassRoom> classRooms;
    private List<Teacher> teachers;

    public School(Long id, String name, Integer number, Boolean publicSchool, List<ClassRoom> classRooms) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.publicSchool = publicSchool;
        this.classRooms = classRooms;
    }

    public School() {
        classRooms = new ArrayList<>();
        teachers = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "School{" + "id=" + id + ", name='" + name + '\'' + ", number=" + number + ", publicSchool=" + publicSchool + ", classRooms=" + classRooms + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id) && Objects.equals(name, school.name) && Objects.equals(number, school.number) && Objects.equals(publicSchool, school.publicSchool) && Objects.equals(classRooms, school.classRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, publicSchool, classRooms);
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getPublicSchool() {
        return publicSchool;
    }

    public void setPublicSchool(Boolean publicSchool) {
        this.publicSchool = publicSchool;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
