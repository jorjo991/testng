package org.solvd.school.servie;

import org.solvd.school.model.School;
import org.solvd.school.model.Teacher;

import java.util.List;
import java.util.Objects;

public class TeacherService {

    private final School school;

    public TeacherService(School school) {
        this.school = school;
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null) throw new RuntimeException("Invalid input: Teacher is null");
        if (!school.getTeachers().contains(teacher)) {
            school.getTeachers().add(teacher);
        }
    }

    public List<Teacher> getAllTeacher() {
        return school.getTeachers();
    }

    public Teacher getTeacherById(Long id) {

        return school.getTeachers().stream().
                filter(teacher -> Objects.equals(teacher.getId(), id)).
                findFirst().
                orElseThrow(() -> new RuntimeException("Invalid ID"));

    }

    public List<Teacher> getTeacherByName(String name) {

        if (school.getTeachers().isEmpty()) throw new RuntimeException("There is no teacher");
        if (name == null) throw new NullPointerException("Invalid input");

        return school.getTeachers().stream().
                filter(teacher -> Objects.equals(teacher.getName(), name)).
                toList();

    }

    public void removeTeacher(Long id) {
        school.getTeachers().removeIf(teacher -> Objects.equals(teacher.getId(), id));
    }

    public double getAverageSalary() {
        return school.getTeachers().stream().
                mapToLong(Teacher::getSalary).
                average().
                orElse(0);
    }

}
