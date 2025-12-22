package org.solvd.school.servie;

import org.solvd.school.model.ClassRoom;
import org.solvd.school.model.School;
import org.solvd.school.model.Student;
import org.solvd.school.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassRoomService {

    private School school;

    public ClassRoomService(School school) {
        this.school = school;
    }

    public void addTeacherToClass(Teacher teacher, ClassRoom classRoom) {
        if (teacher == null || classRoom == null) throw new IllegalArgumentException("Invalid input detected");
        if (!school.getTeachers().contains(teacher)) throw new IllegalArgumentException("Invalid teacher detected");
        if (!school.getClassRooms().contains(classRoom))
            throw new IllegalArgumentException("ClassRoom does not exist in School");
        //chek for duplication
        if (!classRoom.getTeachers().contains(teacher)) classRoom.getTeachers().add(teacher);
    }

    public void removeTeacherFromClass(Teacher teacher, ClassRoom classRoom) {

        if (teacher == null || classRoom == null) throw new IllegalArgumentException("Invalid input detected");
        if (!school.getTeachers().contains(teacher)) throw new IllegalArgumentException("Invalid teacher detected");
        if (!school.getClassRooms().contains(classRoom))
            throw new IllegalArgumentException("ClassRoom does not exist in School");
        classRoom.getTeachers().removeIf(teacher1 -> Objects.equals(teacher.getId(), teacher1.getId()));

    }

    public void addStudentInClass(Student student, ClassRoom classRoom) {

        if (student == null || classRoom == null) throw new IllegalArgumentException("Invalid input detected");
        if (!school.getClassRooms().contains(classRoom))
            throw new IllegalArgumentException("ClassRoom does not exist in School");
        if (!classRoom.getStudentList().contains(student)) classRoom.getStudentList().add(student);

    }

    public void removeStudentFromClass(Student student, ClassRoom classRoom) {
        if (student == null || classRoom == null) throw new IllegalArgumentException("Invalid input detected");
        if (!school.getClassRooms().contains(classRoom))
            throw new IllegalArgumentException("ClassRoom does not exist in School");
        classRoom.getStudentList().
                removeIf(student1 -> Objects.equals(student1.getId(), student.getId()));
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        for (ClassRoom classRoom : school.getClassRooms()) {
            studentList.addAll(classRoom.getStudentList());
        }
        return studentList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
