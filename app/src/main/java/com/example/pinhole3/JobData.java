package com.example.pinhole3;

import com.google.firebase.database.DataSnapshot;

public class JobData {
    String annual_salary, job_title;


    public JobData(DataSnapshot dataSnapshot) {
        annual_salary = dataSnapshot.child("annual_salary").getValue(String.class);
        job_title = dataSnapshot.child("job_title").getValue(String.class);
    }

    public String getAnnual_salary() {
        return annual_salary;
    }


    public String getJob_title() {
        return job_title;
    }



}
