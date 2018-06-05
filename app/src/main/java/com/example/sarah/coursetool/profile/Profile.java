package com.example.sarah.coursetool.profile;

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
    Map<Course> getCourses();

    /**
     * Gets this profiles grade in a course
     * @param CourseID
     * @return Grade
     */
    int getCourseGrade(String CourseID);
}
