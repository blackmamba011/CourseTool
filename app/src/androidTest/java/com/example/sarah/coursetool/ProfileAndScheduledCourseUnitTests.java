package com.example.sarah.coursetool;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.sarah.coursetool.Course.CourseInterface;
import com.example.sarah.coursetool.Course.ScheduledCourse;
import com.example.sarah.coursetool.profile.StudentProfile;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ProfileAndScheduledCourseUnitTests {
    StudentProfile testProf;
    ScheduledCourse scheduledCourse;
    ArrayList<CourseInterface> exampleCourses;
    Date epoch;

    @BeforeClass
    public void initializeTestProfile() {
        epoch = new Date(0);

        ArrayList<Integer> preReqs = new ArrayList<Integer>();
        preReqs.add(5);

        HashMap<Integer, Integer> grades = new HashMap<Integer, Integer>();
        grades.put(134, 50);
        grades.put(135, 90);

        ArrayList<Date> startTimeEndTime = new ArrayList<Date>();
        startTimeEndTime.add(epoch);

        scheduledCourse = new ScheduledCourse(134, 456, "Aziz", "CSCI", "Example Description", startTimeEndTime, startTimeEndTime, preReqs);

        exampleCourses = new ArrayList<CourseInterface>();
        exampleCourses.add(scheduledCourse);

        testProf = new StudentProfile("userName", "password", "Frank Lustre", epoch, exampleCourses, grades);
    }

    @Test
    public void profileTests()
    {
        assertEquals(testProf.getBirthday(), new Date(0));
        assertEquals(testProf.getCourseGrade(134),50);
        assertEquals(testProf.getCourses().get(0),scheduledCourse);
        assertEquals(testProf.getName(),"Frank Lustre");
        assertEquals(testProf.getPassword(),"password");
        assertEquals(testProf.getUserName(),"userName");
    }

    @Test
    public  void scheduledCourseTests()
    {
        assertEquals(scheduledCourse.getDeptCode(),"CSCI");
        assertEquals(scheduledCourse.getDesc(),"Example Description");
        assertEquals(scheduledCourse.getEndTimes().get(0),epoch);
        assertEquals(scheduledCourse.getID(),134);
        assertEquals(scheduledCourse.getPrereqs().get(0).intValue(),5);
        assertEquals(scheduledCourse.getProf(),"Aziz");
        assertEquals(scheduledCourse.getRoom(),456);
        assertEquals(scheduledCourse.getStartTimes().get(0),epoch);

    }
}
