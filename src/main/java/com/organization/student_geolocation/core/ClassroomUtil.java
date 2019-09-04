package com.organization.student_geolocation.core;

import com.organization.student_geolocation.core.model.Classroom;
import com.organization.student_geolocation.core.model.Student;
import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassroomUtil is the main utility class
 *
 */
public class ClassroomUtil {

  /**
   * This method allows find students in the given classroom list
   *
   * @param studentList a list of {@link com.organization.student_geolocation.core.model.Student} class
   * @param classroomList a list of
   * {@link com.organization.student_geolocation.core.model.Classroom} class
   * @return a list of {@link com.organization.student_geolocation.core.model.Student} class
   */
  public static List<Student> studentsInClasses(@NotNull List<Student> studentList,
      @NotNull List<Classroom> classroomList) throws IllegalArgumentException {

    if (studentList == null || classroomList == null) {
      throw new IllegalArgumentException("null values not allowed");
    }
    
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
