package com.organization.student_geolocation.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.organization.student_geolocation.core.model.Classroom;
import com.organization.student_geolocation.core.model.Student;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomUtilTest {

  @Test
  public void scenario_1() {

    String jsonStudentListString = "["
        + "{ 'name': 'John Wilson', 'latitude': 34.069149, 'longitude': -118.442639 }, "
        + "{ 'name': 'Jane Graham', 'latitude': 34.069601, 'longitude': -118.441862 }, "
        + "{ 'name': 'Pam Bam', 'latitude': 34.071513, 'longitude': -118.441181 }"
        + "]";

    String jsonClassroomListString = "["
        + "{ 'name': 'Principles of computational geo-location analysis', 'latitude':\n"
        + "34.069140, 'longitude': -118.442689 }, "
        + "{ 'name': 'Sedimentary Petrology', 'latitude': 34.069585, 'longitude':\n"
        + "-118.441878 }, "
        + "{ 'name': 'Introductory Psychobiology', 'latitude': 34.069742, 'longitude':\n"
        + "-118.441312 }, "
        + "{ 'name': 'Art of Listening', 'latitude': 34.070223, 'longitude': -118.440193 }, "
        + "{ 'name': 'Art Hitory', 'latitude': 34.071528, 'longitude': -118.441211 }"
        + "]";

    String jsonExpectedStudentListString = "["
        + "{'latitude': 34.069149, 'name': 'John Wilson', 'longitude': -118.442639}, "
        + "{'latitude': 34.069601, 'name': 'Jane Graham', 'longitude': -118.441862}, "
        + "{'latitude': 34.071513, 'name': 'Pam Bam', 'longitude': -118.441181}"
        + "]";
    List<Student> studentList = new Gson().fromJson(jsonStudentListString, new TypeToken<List<Student>>(){}.getType());

    List<Classroom> classroomList = new Gson().fromJson(jsonClassroomListString,
        new TypeToken<List<Classroom>>(){}.getType());

    List<Student> expectedStudentList = new Gson().fromJson(jsonExpectedStudentListString,
        new TypeToken<List<Student>>(){}.getType());

    List<Student> result = ClassroomUtil.studentsInClasses(studentList, classroomList);

    assert(result.size() == expectedStudentList.size());
    assertTrue(result.containsAll(expectedStudentList));
  }

  @Test
  public void scenario_2() {

    String jsonStudentListString = "["
        + "{ 'name': 'John Wilson', 'latitude': 34.069849, 'longitude': -118.443539 }, "
        + "{ 'name': 'Jane Graham', 'latitude': 34.069901, 'longitude': -118.441562 }, "
        + "{ 'name': 'Pam Bam', 'latitude': 34.071523, 'longitude': -118.441171 }"
        + "]";

    String jsonClassroomListString = "["
        + "{ 'name': 'Principles of computational geo-location analysis', 'latitude': 34.069140, 'longitude': -118.442689 }, "
        + "{ 'name': 'Sedimentary Petrology', 'latitude': 34.069585, 'longitude': -118.441878 }, "
        + "{ 'name': 'Introductory Psychobiology', 'latitude': 34.069742, 'longitude': -118.441312 }, "
        + "{ 'name': 'Art of Listening', 'latitude': 34.070223, 'longitude': -118.440193 }, "
        + "{ 'name': 'Art Hitory', 'latitude': 34.071528, 'longitude': -118.441211 }"
        + "]";

    String jsonExpectedStudentListString = "["
        + "{'latitude': 34.071523, 'name': 'Pam Bam', 'longitude': -118.441171}"
        + "]";
    List<Student> studentList = new Gson().fromJson(jsonStudentListString, new TypeToken<List<Student>>(){}.getType());

    List<Classroom> classroomList = new Gson().fromJson(jsonClassroomListString,
        new TypeToken<List<Classroom>>(){}.getType());
    
    List<Student> expectedStudentList = new Gson().fromJson(jsonExpectedStudentListString,
        new TypeToken<List<Student>>(){}.getType());

    List<Student> result = ClassroomUtil.studentsInClasses(studentList, classroomList);

    assert(result.size() == expectedStudentList.size());
    assertTrue(result.containsAll(expectedStudentList));
  }

}
