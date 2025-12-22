package org.solvd.test.schooltest;

import org.solvd.school.model.ClassRoom;
import org.solvd.school.model.School;
import org.solvd.school.model.Student;
import org.solvd.school.servie.SchoolService;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SchoolServiceTest {

    private SchoolService schoolService;
    private School school;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    private void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeClass
    public void setUpSchoolService() {
        System.out.println("before each method this class this code is executed");
    }

    @BeforeMethod
    public void setUpSchool() {

        school = new School();
        schoolService = new SchoolService(school);
        Student s1 = new Student(1L, "Jon", "Smith", 15, "jon1@gmail.com");
        Student s2 = new Student(2L, "Anna", "Brown", 16, "anna@gmail.com");

        List<Student> classStudents = new ArrayList<>();
        classStudents.add(s1);
        classStudents.add(s2);

        ClassRoom classRoom = new ClassRoom(1L, 21L, 25, classStudents, new ArrayList<>());

        school.getClassRooms().add(classRoom);

    }

    @Test(testName = "test add classRoom method when class is null", expectedExceptions = IllegalArgumentException.class)
    public void testAddClassRoomToSchoolWhenNull() {
        schoolService.addClassRoom(null);
    }

    @Test(testName = "test add classRoom method")
    public void testAddClassRoomToSchool() {

        ClassRoom classRoom = new ClassRoom();
        schoolService.addClassRoom(classRoom);
        assertTrue(school.getClassRooms().contains(classRoom), "classRoom did not added successfully");
    }

    @AfterClass
    public void print() {
        System.out.println("all methods executed");
    }

    @Test(testName = "test remove classRoom method when class is null", expectedExceptions = IllegalArgumentException.class)
    public void testRemoveClassRoomFromSchoolWhenClassIsnull() {
        schoolService.removeClassRoom(null);
    }

    @Test(testName = "test remove class room from school")
    public void testeRemoveClassRoomFromSchool() {
        schoolService.removeClassRoom(school.getClassRooms().getFirst());
        assertTrue(school.getClassRooms().isEmpty());
    }

    @Test(testName = "test getById when id is null", expectedExceptions = IllegalArgumentException.class)
    public void testGetByIdWhenIdIsNull() {
        schoolService.getClassById(null);
    }

    @Test(testName = "test getById when id is invalid", expectedExceptions = IllegalArgumentException.class)
    public void testGetByIdWhenIdIsInvalid() {
        schoolService.getClassById(-2L);
    }

    @Test(testName = "test getBy id method")
    public void testGetClassRoomById() {

        ClassRoom classRoom = school.getClassRooms().getFirst();
        assertEquals(classRoom, schoolService.getClassById(1L));

    }

}
