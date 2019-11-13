package com.example.pinhole3;

import android.os.Bundle;
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

import java.util.ArrayList;

public class JobDataFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_jobdata, container, false);

        //populate recyclerview
        ArrayList<String> jobs = new ArrayList<>();
        jobs.add("State: AL\n" + "Job: Chief Executives\n" + "Salary: $204,590\n");
        jobs.add("State: AL\n" + "Job: General and Operations Manager\n" + "Salary: $118,440\n");
        jobs.add("State: AL\n" + "Job: Industrial Production Manager\n" + "Salary: $103,430\n");
        jobs.add("State: AL\n" + "Job: Aerospace Engineering and Operations Technician\n" + "Salary: $60,630\n");
        jobs.add("State: AL\n" + "Job: Civil Engineering Technician\n" + "Salary: $43,060\n");
        jobs.add("State: AL\n" + "Job: Electrical and Electronics Engineering Technician\n" + "Salary: $61,120\n");
        jobs.add("State: AL\n" + "Job: Electro-Mechanical Technician\n" + "Salary: $62,140\n");
        jobs.add("State: AL\n" + "Job: Environmental Engineering Technician\n" + "Salary: $50,540\n");
        jobs.add("State: AL\n" + "Job: Mechanical Engineering Technician\n" + "Salary: $57,670\n");
        jobs.add("State: AL\n" + "Job: Surveying and Mapping Technician\n" + "Salary: $42,850\n");
        jobs.add("State: AL\n" + "Job: Food Scientists and Technologist\n" + "Salary: $54,340\n");


        // set up the RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.jobdatalist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter = new MyRecyclerViewAdapter(this.getContext(), jobs);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        return root;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}