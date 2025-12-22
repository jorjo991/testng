package org.solvd.test.schooltest;

import org.solvd.school.model.ClassRoom;
import org.solvd.school.model.Student;
import org.solvd.school.servie.StudentService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StudentServiceTest {
    private List<ClassRoom> classRooms;
    private StudentService studentService;

    @BeforeMethod
    public void setup() {
        classRooms = new ArrayList<>();
        studentService = new StudentService(classRooms);
    }

    @Test(testName = "Invalid classroom test", priority = 1)
    public void addStudentOnClassWhenClassIsNotAtUniversity() {

        Student student = new Student(1L, "Jon", "Smith", 15, "jonSmith@gmail.com");
        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, new ArrayList<>(), new ArrayList<>());
        Assert.assertThrows(
                RuntimeException.class,
                () -> studentService.addStudent(student, classRoom)
        );
    }

    @Test(testName = "Add student in classRoom", priority = 2)
    public void addStudentInClassRoom() {

        Student student = new Student(1L, "Jon", "Smith", 15, "jonSmith@gmail.com");
        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, new ArrayList<>(), new ArrayList<>());
        classRooms.add(classRoom);
        studentService.addStudent(student, classRoom);
        assertTrue(classRoom.getStudentList().contains(student));

    }

    @Test(testName = "try to remove student if he/she is not presented", groups = "removegroup")
    public void removesStudentFromClassIfNotPresentTest() {

        Student student = new Student(1L, "Jon", "Smith", 15, "jonSmith@gmail.com");
        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, new ArrayList<>(), new ArrayList<>());
        assertThrows(RuntimeException.class, () -> {
            studentService.removeStudent(1L);
        });
    }

    @Test
    public void removePresentedStudentFromClassTest() {
        Student student = new Student(1L, "Jon", "Smith", 15, "jonSmith@gmail.com");
        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, new ArrayList<>(), new ArrayList<>());
        classRoom.getStudentList().add(student);
        classRooms.add(classRoom);
        studentService.removeStudent(1L);

        assertTrue(classRoom.getStudentList().isEmpty());

    }

    @Test(testName = "get all students form list")
    public void testGetAllStudentTest() {

        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 16, "anna@gmail.com");
        Student s3 = new Student(3L, "Mike", "Taylor", 14, "mike@gmail.com");
        Student s4 = new Student(4L, "Sara", "White", 17, "sara@gmail.com");

        Student s5 = new Student(5L, "Tom", "Green", 15, "tom@gmail.com");
        Student s6 = new Student(6L, "Emma", "Black", 16, "emma@gmail.com");
        Student s7 = new Student(7L, "Leo", "King", 14, "leo@gmail.com");
        Student s8 = new Student(8L, "Nina", "Scott", 17, "nina@gmail.com");

        List<Student> class1Students = new ArrayList<>();
        class1Students.add(s1);
        class1Students.add(s2);
        class1Students.add(s3);
        class1Students.add(s4);

        List<Student> class2Students = new ArrayList<>();
        class2Students.add(s5);
        class2Students.add(s6);
        class2Students.add(s7);
        class2Students.add(s8);
        List<Student> allStudents = new ArrayList<>(class1Students);
        allStudents.addAll(class2Students);

        ClassRoom classRoom1 =
                new ClassRoom(1L, 21L, 25, class1Students, new ArrayList<>());

        ClassRoom classRoom2 =
                new ClassRoom(2L, 22L, 25, class2Students, new ArrayList<>());

        classRooms.add(classRoom1);
        classRooms.add(classRoom2);
        assertEquals(studentService.getAllStudent(), allStudents, "not all student is presented");
    }

    @Test(testName = "Invalid student name")
    public void GetStudentByNameWhenNameIsInvalidest() {

        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 16, "anna@gmail.com");
        Student s3 = new Student(3L, "Mike", "Taylor", 14, "mike@gmail.com");
        Student s4 = new Student(4L, "Sara", "White", 17, "sara@gmail.com");

        List<Student> class1Students = new ArrayList<>();
        class1Students.add(s1);
        class1Students.add(s2);
        class1Students.add(s3);
        class1Students.add(s4);

        ClassRoom classRoom1 =
                new ClassRoom(1L, 21L, 25, class1Students, new ArrayList<>());
        classRooms.add(classRoom1);

        assertThrows(RuntimeException.class, () -> {
            studentService.getStudentByName(null);
        });
    }

    @Test(testName = "student list are empty")
    public void getStudentByNameWhenStudentAreEmptyTest() {
        assertThrows(RuntimeException.class, () -> {
            studentService.getStudentByName("jhon");
        });

    }

    @Test(testName = "")
    public void getStudentByNameTest() {

        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 16, "anna@gmail.com");
        Student s3 = new Student(3L, "Mike", "Taylor", 14, "mike@gmail.com");
        Student s4 = new Student(4L, "Sara", "White", 17, "sara@gmail.com");

        List<Student> class1Students = new ArrayList<>();
        class1Students.add(s1);
        class1Students.add(s2);
        class1Students.add(s3);
        class1Students.add(s4);

        ClassRoom classRoom1 =
                new ClassRoom(1L, 21L, 25, class1Students, new ArrayList<>());
        classRooms.add(classRoom1);
        List<Student> getstudentList = new ArrayList<>();
        getstudentList.add(s1);
        assertEquals(studentService.getStudentByName("Jon"), getstudentList);

    }

    @Test(testName = "invalid id test")
    public void getStudentByIdInvalidInputTest() {
        assertThrows(RuntimeException.class, () -> {
            studentService.getStudentById(-1L);
        });
    }

    public void getStudentByIdTest() {
        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 16, "anna@gmail.com");
        Student s3 = new Student(3L, "Mike", "Taylor", 14, "mike@gmail.com");
        Student s4 = new Student(4L, "Sara", "White", 17, "sara@gmail.com");

        List<Student> class1Students = new ArrayList<>();
        class1Students.add(s1);
        class1Students.add(s2);
        class1Students.add(s3);
        class1Students.add(s4);

        ClassRoom classRoom1 =
                new ClassRoom(1L, 21L, 25, class1Students, new ArrayList<>());
        classRooms.add(classRoom1);

        assertEquals(studentService.getStudentById(1L), s1);
    }

    @Test(testName = "calculate average age test")
    public void testCalculateAverageStudentAge() {

        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 15, "anna@gmail.com");
        Student s3 = new Student(3L, "Mike", "Taylor", 20, "mike@gmail.com");
        Student s4 = new Student(4L, "Sara", "White", 30, "sara@gmail.com");

        List<Student> class1Students = new ArrayList<>();
        class1Students.add(s1);
        class1Students.add(s2);
        class1Students.add(s3);
        class1Students.add(s4);

        ClassRoom classRoom1 =
                new ClassRoom(1L, 21L, 25, class1Students, new ArrayList<>());
        classRooms.add(classRoom1);

        assertEquals(studentService.calculateAverageStudentAge(), 20, "average age is not correct");
    }

    @AfterClass
    public void printAfterClassMethod() {
        System.out.println("Objects initialize successfully");
    }

    @AfterMethod
    public void printAfterEachTest() {
        System.out.println("test case executed");
    }

}