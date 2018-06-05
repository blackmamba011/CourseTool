package com.example.sarah.coursetool.Database;

import com.example.sarah.coursetool.Course.CourseInterface;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Interface for a Database that has access to a users information and course schedule
 */
public interface UserDatabase {

    /**
     * Gets all the courses this user is enrolled in and has finished
     * @return userCourses
     */
    ArrayList<CourseInterface> getUserCourses();

    /**
     * Gets all available courses
     * @return scheduleCourses
     */
    ArrayList<CourseInterface> getScheduledCourse();

    /**
     * Gets the users grade in a course. Returns -1 if the user has not finished the course yet.
     * @param scheduledCourseID
     * @return grade
     */
    int getGrade(int scheduledCourseID);

    /**
     * Enrolls the user in a course
     * @param schedID
     * @throws InvalidParameterException
     */
    void enroll(int schedID) throws InvalidParameterException;

    /**
     * Removes the user from a course
     * @param schedID
     * @throws InvalidParameterException
     */
    void removeCourse (int schedID) throws InvalidParameterException;

    /**
     * Gets the user's first and last name
     * @return name
     */
    String getName();

    /**
     * Gets the username
     * @return username
     */
    String getUsername();
}
