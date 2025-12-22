package org.solvd.test.schooltest;

import org.solvd.school.model.School;
import org.solvd.school.model.Teacher;
import org.solvd.school.servie.TeacherService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TeacherServiceTest {

    private TeacherService teacherService;
    private School school;

    @BeforeMethod
    public void setup() {
        school = new School();
        List<Teacher> teachers = new ArrayList<>(List.of(
                new Teacher(1L, "John", "Smith", "john.smith@mail.com", 35, 3000L),
                new Teacher(2L, "Emma", "Johnson", "emma.johnson@mail.com", 42, 4200L),
                new Teacher(3L, "Michael", "Brown", "michael.brown@mail.com", 29, 4000L),
                new Teacher(4L, "Sophia", "Davis", "sophia.davis@mail.com", 38, 3800L),
                new Teacher(5L, "David", "Wilson", "david.wilson@mail.com", 45, 5000L)
        ));
        school.setTeachers(teachers);
        teacherService = new TeacherService(school);

    }

    @Test(testName = "check if teacher is null")
    public void addNullValueTeacherToSchoolTest() {

        Teacher teacher = null;
        assertThrows(RuntimeException.class, () -> {
            teacherService.addTeacher(teacher);
        });

    }

    @Test(testName = "add teacher to school")
    public void testAddTeacher() {

        Teacher teacher = new Teacher(6L, "Luke", "Wilson", "luke.wilson@mail.com", 45, 5000L);
        teacherService.addTeacher(teacher);
        assertTrue(school.getTeachers().contains(teacher));
    }

    @Test
    public void testGetAllTeacher() {

        List<Teacher> allTeachers = school.getTeachers();
        assertEquals(teacherService.getAllTeacher(), allTeachers, "did not ");
    }

    @Test(testName = "test get teacher by id method")
    public void testGetTeacherById() {
        assertEquals(teacherService.getTeacherById(1L), new Teacher(1L, "John", "Smith", "john.smith@mail.com", 35, 3000L));
    }

    @Test(expectedExceptions = RuntimeException.class, testName = "test getByName method when teacher list is empty")
    public void testGetTeacherByNameWhenTeacherListIsEmpty() {
        school.setTeachers(new ArrayList<>());
        teacherService.getTeacherByName("test");
    }

    @Test(expectedExceptions = NullPointerException.class, testName = "test getByName method when name is null")
    public void testGetByNameWhenNameisNull() {
        teacherService.getTeacherByName(null);
    }

    @Test(testName = "test getTeacherByName method if teachers is presented")
    public void testGetTeacherByNameIfNameIsPresented() {
        List<Teacher> getTeachers = new ArrayList<>();
        getTeachers.add(new Teacher(1L, "John", "Smith", "john.smith@mail.com", 35, 3000L));
        assertEquals(teacherService.getTeacherByName("John"), getTeachers);
    }

    @Test(testName = "test getTeacherByName method if teachers is not presented")
    public void testGetTeacherByNameIfNameIsNotPresented() {
        List<Teacher> getTeachers = new ArrayList<>();
        assertEquals(teacherService.getTeacherByName("Giorgi"), getTeachers);
    }

    @Test(testName = "test remove teacher test if teacher is in school", groups = "removegroup")
    public void testRemoveTeacher() {
        teacherService.removeTeacher(1L);
        assertFalse(teacherService.getAllTeacher().contains(new Teacher(1L, "John", "Smith", "john.smith@mail.com", 35, 3000L)));
    }

    @Test(testName = "test average salary method")
    public void testGetAverageSalary() {

        assertEquals(teacherService.getAverageSalary(), 4000.0);

    }
}