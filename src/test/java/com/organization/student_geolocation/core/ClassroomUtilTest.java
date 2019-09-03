package com.organization.student_geolocation.core;

import com.organization.student_geolocation.core.model.Classroom;
import com.organization.student_geolocation.core.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomUtilTest {

  @Test
  public void scenario1() {

    List<Student> studentList = new ArrayList<Student>(){{
      add(new Student("John Wilson", 34.069149, -118.442639));
      add(new Student("Jane Graham", 34.069601, -118.441862));
      add(new Student("Pam Bam", 34.071513, -118.441181));
    }};

    List<Classroom> classroomList = new ArrayList<Classroom>(){{
      add(new Classroom("Principles of computational geo-location analysis", 34.069140,
          -118.442689));
      add(new Classroom("Sedimentary Petrology", 34.069585, -118.441878));
      add(new Classroom("Introductory Psychobiology", 34.069742, -118.441312));
      add(new Classroom("Art of Listening", 34.070223, -118.440193));
      add(new Classroom("Art History", 34.071528, -118.441211));
    }};
    List<Student> expectedStudentList = new ArrayList<Student>(){{
      add(new Student("John Wilson", 34.069149, -118.442639));
      add(new Student("Jane Graham", 34.069601, -118.441862));
      add(new Student("Pam Bam", 34.071513, -118.441181));
    }};

    List<Student> result = ClassroomUtil.studentsInClasses(studentList, classroomList);

    assert(result.size() == expectedStudentList.size());
    assertTrue(result.containsAll(expectedStudentList));
  }

  @Test
  public void scenario2() {

    List<Student> studentList = new ArrayList<Student>(){{
      add(new Student("John Wilson", 34.069849, -118.443539));
      add(new Student("Jane Graham", 34.069901, -118.441562));
      add(new Student("Pam Bam", 34.071523, -118.441171));
    }};

    List<Classroom> classroomList = new ArrayList<Classroom>(){{
      add(new Classroom("Principles of computational geo-location analysis", 34.069140, -118.442689));
      add(new Classroom("Sedimentary Petrology", 34.069585, -118.441878));
      add(new Classroom("Introductory Psychobiology", 34.069742, -118.441312));
      add(new Classroom("Art of Listening", 34.070223, -118.440193));
      add(new Classroom("Art History", 34.071528, -118.441211));
    }};
    List<Student> expectedStudentList = new ArrayList<Student>(){{
      add(new Student("Pam Bam", 34.071523, -118.441171));
    }};

    List<Student> result = ClassroomUtil.studentsInClasses(studentList, classroomList);

    assert(result.size() == expectedStudentList.size());
    assertTrue(result.containsAll(expectedStudentList));
  }

}
