package org.solvd.school.servie;

import org.solvd.school.model.ClassRoom;
import org.solvd.school.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService {

   private List<ClassRoom> classRooms;

    public StudentService(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    public boolean chekStudentAge(Student student) {
        if (student == null) throw new RuntimeException("Student value is null");
        return student.getAge() > 4 && student.getAge() < 19;
    }

    public void addStudent(Student student, ClassRoom classRoom) {

        classRooms.stream().
                filter(classRoom1 -> Objects.equals(classRoom1.getId(), classRoom.getId())).
                findFirst().orElseThrow(() -> new RuntimeException("Class was not found")).
                getStudentList().add(student);
    }

    public void removeStudent(Long id) {

        for (ClassRoom classRoom : classRooms) {
            for (Student student : classRoom.getStudentList()) {
                if (Objects.equals(student.getId(), id)) {
                    classRoom.getStudentList().remove(student);
                    return;
                }
            }
        }
        throw new RuntimeException("Invalid id : Student is not presented");
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        classRooms.forEach(classRoom -> studentList.addAll(classRoom.getStudentList()));
        return studentList;
    }

    public List<Student> getStudentByName(String name) {

        if (name == null || name.isEmpty()) throw new RuntimeException("Name is empty");
        if (getAllStudent().isEmpty()) throw new RuntimeException("Student is not Presented");
        return getAllStudent().stream().
                filter(student -> student.getName().equals(name)).
                toList();

    }

    public Student getStudentById(Long id) {

        if (id < 0) throw new RuntimeException("Invalid  input: id must be greater than zero");

        return getAllStudent().stream().
                filter(student -> student.getId().equals(id)).toList().getFirst();

    }

    public Double calculateAverageStudentAge() {

        return getAllStudent().stream().
                mapToLong(Student::getAge).
                average().orElse(0);
    }

}
