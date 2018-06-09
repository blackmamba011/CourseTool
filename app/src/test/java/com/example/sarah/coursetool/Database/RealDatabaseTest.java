package com.example.sarah.coursetool.Database;

import com.example.sarah.coursetool.Course.CourseInterface;
import com.example.sarah.coursetool.UserProfile.Profile;

import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for the RealDatabaseTest class
 */
public class RealDatabaseTest {
    final RealDatabase database = new RealDatabase();

    final static String validUsername = "rlowe90";
    final static String validPassword = "lordOfTheRings340";
    final static int testscheduledCourseID = 1234;

    /**
     * Tests that the getProfileDatabase method returns a UserDatabase when given correct credentials
     */
    @Test
    public void getValidProfileDatabase() {
        UserDatabase loggedInDatabase = database.getProfileDatabase(validUsername, validPassword);

        assertEquals(loggedInDatabase.getClass(), UserDatabase.class);
    }

    /**
     * Tests that the getProfileDatabase method throws an exception  when given incorrect credentials
     */
    @Test(expected = InvalidParameterException.class)
    public void getInvalidProfileDatabase() {
        database.getProfileDatabase(validUsername, "PHPisBAD");
    }

    /**
     * Tests the getUserProfile method
     */
    @Test
    public void getUserProfile() {
        UserDatabase loggedInDatabase = database.getProfileDatabase(validUsername, validPassword);

        assertEquals(loggedInDatabase.getUserProfile().getClass(), Profile.class);
    }

    /**
     * Tests the getScheduledCourses method
     */
    @Test
    public void getScheduledCourses() {
        UserDatabase loggedInDatabase = database.getProfileDatabase(validUsername, validPassword);

        ArrayList<CourseInterface> scheduledCourses = loggedInDatabase.getScheduledCourses();
        assertTrue(scheduledCourses.get(0).getID() == testscheduledCourseID);
    }

    /**
     * Tests the enroll and removeCourse methods
     */
    @Test
    public void enrollAndRemove() {
        UserDatabase loggedInDatabase = database.getProfileDatabase(validUsername, validPassword);
        loggedInDatabase.removeCourse(testscheduledCourseID);

        ArrayList<CourseInterface> scheduledCourses = loggedInDatabase.getScheduledCourses();

        for (CourseInterface course: scheduledCourses) {
            assertNotEquals(testscheduledCourseID, course.getID());
        }

        loggedInDatabase.enroll(testscheduledCourseID);

        boolean contains1234 = false;
        for (CourseInterface course: scheduledCourses) {
            if (course.getID() == testscheduledCourseID) {
                contains1234 = true;
                break;
            }
        }

        assertTrue(contains1234);
    }

}