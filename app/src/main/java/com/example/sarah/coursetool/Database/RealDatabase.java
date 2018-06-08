package com.example.sarah.coursetool.Database;

import com.example.sarah.coursetool.Course.CourseInterface;
import com.example.sarah.coursetool.profile.Profile;
import com.example.sarah.coursetool.profile.StudentProfile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RealDatabase implements LoginDatebaseInterface, UserDatabase {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference ref = database.getReference();
    private DataSnapshot snapshot;

    private Profile userProfile;

    public RealDatabase() {
        ref.getParent().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                updateSnapshot(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void updateSnapshot(DataSnapshot newData) {
        snapshot = newData;
    }

    @Override
    public UserDatabase getProfileDatabase(String userName, String password) throws InvalidParameterException {

        DataSnapshot profileSnapshot;
        try {
            profileSnapshot = snapshot.child("Profile").child(userName);
        } catch (NullPointerException ex) {
            throw new InvalidParameterException("Username not found.");
        }
        String databasePass = profileSnapshot.child("Password").getValue().toString();
        if (!databasePass.equals(password))
            throw new InvalidParameterException("Incorrect Password");

        String name = profileSnapshot.child("Name").getValue().toString();
        Date birthday = new Date(profileSnapshot.child("Birthday").getValue().toString());
        

        Iterable<DataSnapshot> courseMarks = profileSnapshot.child("Courses").child("Mark").getChildren();
        Iterable<DataSnapshot> courseSchedIDs = profileSnapshot.child("Courses").child("SchedEntries").getChildren();


        ArrayList<CourseInterface> enrolledCourses = new ArrayList<CourseInterface>();
        HashMap<Integer, Integer> schedIdGradeHashmap = new HashMap<>();
        while (courseMarks.iterator().hasNext()) {
            schedIdGradeHashmap.put(Integer.parseInt(courseSchedIDs.iterator().next().toString()), Integer.parseInt(courseMarks.iterator().next().toString()));
            //TODO create course schedule objects by looking up our schedule Id's, and adding them to the enrolledCourses
            // enrolledCourses.add()
        }

        StudentProfile result = new StudentProfile(userName, password, name, birthday,
                enrolledCourses, schedIdGradeHashmap);
        //TODO make a class that can actually create the return type for this method, implement, and return it
        return null;
    }

    @Override
    public Profile getUserProfile() {
        return null;
    }

    @Override
    public ArrayList<CourseInterface> getScheduledCourses() {
        return null;
    }

    @Override
    public void enroll(int schedID) throws InvalidParameterException {

    }

    @Override
    public void removeCourse(int schedID) throws InvalidParameterException {

    }
}