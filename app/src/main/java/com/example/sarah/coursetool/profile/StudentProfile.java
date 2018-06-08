package com.example.sarah.coursetool.profile;

import com.example.sarah.coursetool.Course.CourseInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class StudentProfile implements Profile {
    String userName, password, name;
    Date birthday;
    ArrayList<CourseInterface> enrolledCourses;

    // key = courseID, value = grade
    HashMap<Integer, Integer> grades;

    public StudentProfile(String userName, String password, String name, Date birthday,
                          ArrayList<CourseInterface> enrolledCourses, HashMap<Integer, Integer> grades) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.enrolledCourses = enrolledCourses;
        this.grades = grades;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentProfile)) return false;
        StudentProfile that = (StudentProfile) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(enrolledCourses, that.enrolledCourses) &&
                Objects.equals(grades, that.grades);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, password, name, birthday, enrolledCourses, grades);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Date getBirthday() {
        return null;
    }

    @Override
    public ArrayList<CourseInterface> getCourses() {
        return null;
    }

    @Override
    public int getCourseGrade(int CourseID) {
        return 0;
    }
}
