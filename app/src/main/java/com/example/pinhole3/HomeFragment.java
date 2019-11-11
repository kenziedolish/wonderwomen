package com.example.pinhole3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    DatabaseReference mDatabase;
    DatabaseReference mDatabaseMicro;
    DatabaseReference mDatabaseSmall;


    MyRecyclerViewAdapter adapter;
    ArrayList<JobData> jobs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                JobData post = dataSnapshot.getValue(JobData.class);
                Log.i("YIKES", post.getAnnual_salary());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("FAIL", "The read failed: " + databaseError.getCode());
            }
        });

        jobs = new ArrayList<JobData>();

        final DataSnapshotCallback callback = new DataSnapshotCallback() {
            @Override
            public void gotDataSnapshot(DataSnapshot snapshot) {
                JobData jobData = new JobData(snapshot);
                jobs.add(jobData);
                adapter.updateDataSet(jobs);
                Log.v("ARRAY LIST CONTENTS", jobs.get(0).getAnnual_salary());
                Log.v("DATA","Salary: " + jobData.getAnnual_salary() + " Title: " + jobData.getJob_title());
            }
        };

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabaseMicro = mDatabase.child("ANNUAL_SALARY");
        mDatabaseSmall = mDatabase.child("JOB_TITLE");

        ValueEventListener eventListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                callback.gotDataSnapshot(dataSnapshot);  //CALLS THE CALLBACK AND SENDS THE DATASNAPSHOT TO IT
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Cancelled",databaseError.toString());
            }
        };

        mDatabaseMicro.addListenerForSingleValueEvent(eventListener);
        mDatabaseSmall.addListenerForSingleValueEvent(eventListener);


        // set up the RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter = new MyRecyclerViewAdapter(this.getContext(), jobs);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        return root;
    }

    interface DataSnapshotCallback {
        void gotDataSnapshot(DataSnapshot snapshot);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}