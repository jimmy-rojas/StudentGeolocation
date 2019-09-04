package com.organization.student_geolocation.core.model;

/**
 * Student is an student model
 *
 */
public class Student {

  private String name;
  private double latitude;
  private double longitude;

  /**
   * Default constructor
   *
   * @param name a string value, the student's name
   * @param latitude a double value, the student's latitude
   * @param longitude a double value, the student's longitude
   */
  public Student(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student that = (Student) o;

    if (latitude != that.latitude) {
      return false;
    }
    if (longitude != that.longitude) {
      return false;
    }
    return name != null ? name.equalsIgnoreCase(that.name) : that.name == null;
  }
}
