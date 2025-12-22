package org.solvd.test.schooltest;

import org.solvd.school.model.ClassRoom;
import org.solvd.school.model.School;
import org.solvd.school.model.Student;
import org.solvd.school.model.Teacher;
import org.solvd.school.servie.ClassRoomService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ClassRoomServiceTest {

    private ClassRoomService classRoomService;
    private School school;

    @BeforeTest
    public void beforeTest() {
        System.out.println("test will run successfully");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("test runed successfully");
    }

    @BeforeMethod
    public void setUp() {

        school = new School();
        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 16, "anna@gmail.com");

        Teacher teacher1 = new Teacher(1L, "John", "Smith", "john.smith@mail.com", 35, 3000L);
        Teacher teacher2 = new Teacher(2L, "Emma", "Johnson", "emma.johnson@mail.com", 42, 4200L);

        school.getTeachers().add(teacher1);
        school.getTeachers().add(teacher2);

        List<Student> class1Students = new ArrayList<>();
        class1Students.add(s1);
        class1Students.add(s2);

        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, class1Students, new ArrayList<>());
        classRoom.getTeachers().add(teacher1);
        classRoom.getTeachers().add(teacher2);
        school.getClassRooms().add(classRoom);
        classRoomService = new ClassRoomService(school);

    }

    @Test(testName = "Test addTeacherMethod if teacher is null", expectedExceptions = IllegalArgumentException.class)
    public void testAddTeacherToClassIfTeacherIsNull() {

        classRoomService.addTeacherToClass(null, new ClassRoom());
    }

    @Test(testName = "Test addTeacherMethod if classRoom is null", expectedExceptions = IllegalArgumentException.class)
    public void testAddTeacherToClassIfClassRoomIsNull() {

        classRoomService.addTeacherToClass(new Teacher(), null);
    }

    @Test(testName = "Test addTeacherMethod if teacher does not work in school", expectedExceptions = IllegalArgumentException.class)
    public void testAddTeacherToClassIfTeacherIsNotInSchool() {

        classRoomService.addTeacherToClass(new Teacher(), school.getClassRooms().getFirst());
    }

    @Test(testName = "Test addTeacherMethod if class is not presented in school", expectedExceptions = IllegalArgumentException.class)
    public void testAddTeacherToClassIfClassIsNotPresented() {

        classRoomService.addTeacherToClass(school.getTeachers().getFirst(), new ClassRoom());
    }

    @Test
    public void testAddTeacherToClass() {
        Teacher teacher3 = new Teacher(3L, "Luke", "Smith", "john.smith@mail.com", 35, 3000L);
        school.getTeachers().add(teacher3);
        classRoomService.addTeacherToClass(teacher3, school.getClassRooms().getFirst());
        assertTrue(school.getClassRooms().getFirst().getTeachers().contains(teacher3));
    }

    @Test(testName = "test removeTeacherFromClass method if teacher is null", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveTeacherFromClassIfTeacherIsNull() {
        classRoomService.removeTeacherFromClass(null, new ClassRoom());
    }

    @Test(testName = "test remove method if classRoom is Null", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveTeacherFromClassIfClassRoomIsNull() {
        classRoomService.removeTeacherFromClass(new Teacher(), null);
    }

    @Test(testName = "test removeTeacherFromClass when teacher is not in Class", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveTeacherFromClassTeacherIsNotInClass() {
        classRoomService.removeTeacherFromClass(new Teacher(), school.getClassRooms().getFirst());
    }

    @Test(testName = "test removeTeacherFromClass")
    public void testRemoveTeacherFromClass() {
        classRoomService.removeTeacherFromClass(school.getTeachers().getFirst(), school.getClassRooms().getFirst());
        assertFalse(school.getClassRooms().getFirst().getTeachers().contains(school.getTeachers().getFirst()));
    }

    @Test(testName = "test addStudentInClass if student is null", expectedExceptions = IllegalArgumentException.class)
    public void testAddStudentInClassIfStudentIsNull() {
        classRoomService.addStudentInClass(null, new ClassRoom());
    }

    @Test(testName = "test addStudentInClass if classRoom is null", expectedExceptions = IllegalArgumentException.class)
    public void testAddStudentInClassIfClassRoomIsNull() {
        classRoomService.addStudentInClass(new Student(), null);
    }

    @Test(testName = "test addStudentInClass if classRoom does not exist in school", expectedExceptions = IllegalArgumentException.class)
    public void testAddStudentInClassIfClassRoomDoesNotExistInSchool() {
        classRoomService.addStudentInClass(new Student(), new ClassRoom());
    }

    @Test(testName = "test addStudentInClass if classRoom does not exist in school")
    public void testAddStudentInClass() {
        Student s = new Student(3L, "Luke", "Smith", 15, "jon1@gmail.com");
        classRoomService.addStudentInClass(s, school.getClassRooms().getFirst());
        assertTrue(school.getClassRooms().getFirst().getStudentList().contains(s));

    }

    @Test(testName = "test removeStudentFromClass if student is null", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveStudentFromClassIfStudentIsnull() {
        classRoomService.removeStudentFromClass(null, new ClassRoom());
    }

    @Test(testName = "test removeStudentFromClass if ClassRoom is null", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveStudentFromClassIfClassRoomIsnull() {
        classRoomService.removeStudentFromClass(null, new ClassRoom());
    }

    @Test(testName = "test removeStudentFromClass if ClassRoom is not in school", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveStudentFromClassIfClassRoomIsNotInSchool() {
        classRoomService.removeStudentFromClass(new Student(), new ClassRoom());
    }

    @Test(testName = "test RemoveStudentFromClass")
    public void testRemoveStudentFromClass() {
        Student student = school.getClassRooms().getFirst().getStudentList().getFirst();
        ClassRoom classRoom = school.getClassRooms().getFirst();
        classRoomService.removeStudentFromClass(student, classRoom);
        assertFalse(classRoom.getStudentList().contains(student));
    }

    @Test(testName = "test get all student from class")
    public void testGetAllStudentFrom() {

        Student s1 = new Student(3L, "James", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(4L, "Marry", "Brown", 16, "anna@gmail.com");

        List<Student> class2Students = new ArrayList<>();
        class2Students.add(s1);
        class2Students.add(s2);

        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, class2Students, new ArrayList<>());

        school.getClassRooms().add(classRoom);

        List<Student> studentList = new ArrayList<>();

        studentList.addAll(school.getClassRooms().getFirst().getStudentList());
        studentList.add(s1);
        studentList.add(s2);
        assertEquals(studentList, classRoomService.getAllStudent());

    }
}
