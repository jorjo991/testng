package org.solvd.school.servie;

import org.solvd.school.model.ClassRoom;
import org.solvd.school.model.School;

import java.util.Objects;

public class SchoolService {

    private School school;

    public SchoolService(School school) {
        this.school = school;
    }

    public void addClassRoom(ClassRoom classRoom) {
        if (classRoom == null) throw new IllegalArgumentException("ClassRoom is null");
        if (!school.getClassRooms().contains(classRoom)) {
            school.getClassRooms().add(classRoom);
        }
    }

    public void removeClassRoom(ClassRoom classRoom) {
        if (classRoom == null) throw new IllegalArgumentException("classRoom is null");
        if (school.getClassRooms().contains(classRoom)) {
            school.getClassRooms().removeIf(classRoom1 -> Objects.equals(classRoom1, classRoom));
        }
    }

    public ClassRoom getClassById(Long id) {
        if (id == null || id < 0) throw new IllegalArgumentException("Invalid input");
        return school.getClassRooms().stream().
                filter(classRoom -> Objects.equals(classRoom.getId(), id)).
                toList().
                getFirst();
    }

}
