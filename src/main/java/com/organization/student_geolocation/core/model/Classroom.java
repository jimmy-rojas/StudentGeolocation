package com.organization.student_geolocation.core.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.util.LengthUnit;
import com.javadocmd.simplelatlng.window.RectangularWindow;

public class Classroom {

  private static final int SHAPE_SIZE = 20 / 2;
  private String name;
  private double latitude;
  private double longitude;

  public Classroom(String name, double latitude, double longitude) {
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

  public Boolean hasWithin(Student student) {
    LatLng center = new LatLng(latitude, longitude);
    RectangularWindow window = new RectangularWindow(center, SHAPE_SIZE, LengthUnit.METER);
    return window.contains(new LatLng(student.getLatitude(), student.getLongitude()));
  }
}
