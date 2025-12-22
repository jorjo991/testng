package org.solvd.school.model;

import java.util.List;
import java.util.Objects;

public class ClassRoom {

    private Long id;
    private Long number;
    private Integer capacity;
    private List<Student> studentList;
    private List<Teacher> teachers;

    public ClassRoom(Long id, Long number, Integer capacity, List<Student> studentList, List<Teacher> teachers) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.studentList = studentList;
        this.teachers = teachers;
    }

    public ClassRoom() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return Objects.equals(id, classRoom.id) && Objects.equals(number, classRoom.number) && Objects.equals(capacity, classRoom.capacity) && Objects.equals(studentList, classRoom.studentList) && Objects.equals(teachers, classRoom.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, capacity, studentList, teachers);
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", number=" + number +
                ", Capacity=" + capacity +
                ", studentList=" + studentList +
                ", teachers=" + teachers +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

}
