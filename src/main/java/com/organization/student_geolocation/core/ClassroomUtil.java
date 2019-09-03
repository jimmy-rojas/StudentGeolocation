package com.organization.student_geolocation.core;

import com.organization.student_geolocation.core.model.Classroom;
import com.organization.student_geolocation.core.model.Student;
import java.util.List;
import java.util.stream.Collectors;

public class ClassroomUtil {

  public static List<Student> studentsInClasses(List<Student> studentList,
      List<Classroom> classroomList) {

    return studentList.stream()
        .distinct()
        .filter(student ->  {
            for (Classroom classroom : classroomList) {
              if (classroom.hasWithin(student)) {
                return true;
              }
            }
            return false;
          }
        )
        .collect(Collectors.toList());
  }
}
