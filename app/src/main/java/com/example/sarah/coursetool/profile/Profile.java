package com.example.sarah.coursetool.profile;

import com.example.sarah.coursetool.Course.CourseInterface;

import java.util.ArrayList;

/**
 * Interface for profiles
 */
public interface Profile {

    /**
     * Gets the profile's username
     * @return username
     */
    String getUserName();

    /**
     * Gets the profile's username
     * @return password
     */
    String getPassword();

    /**
     * Gets the profiles first and last name
     * @return name
     */
    String getName();

    /**
     * Gets this profiles birthday date
     * @return birthday
     */
    String getBirthday();

    /**
     * Gets all the courses related to this user
     * @return Map of course IDs
     */
    ArrayList<CourseInterface> getCourses();

    /**
     * Gets this profiles grade in a course
     * @param CourseID
     * @return grade
     */
    int getCourseGrade(String CourseID);
}
