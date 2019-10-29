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

public class HomeFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //populate recyclerview
        ArrayList<String> jobs = new ArrayList<>();
        jobs.add("Location: New York, NY\n" + "Job: Software Engineer\n" + "Salary: $100,000\n");
        jobs.add("Location: New York, NY\n" + "Job: IT Help Desk\n" + "Salary: $50,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Scrum Master\n" + "Salary: $120,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Product Manager\n" + "Salary: $80,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Software Engineer\n" + "Salary: $92,500\n");
        jobs.add("Location: New York, NY\n" + "Job: Front-End Developer\n" + "Salary: $85,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Full Stack Developer\n" + "Salary: $105,500\n");
        jobs.add("Location: New York, NY\n" + "Job: Back-End Developer\n" + "Salary: $95,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Software Engineer\n" + "Salary: $100,000\n");
        jobs.add("Location: New York, NY\n" + "Job: IT Help Desk\n" + "Salary: $50,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Scrum Master\n" + "Salary: $120,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Product Manager\n" + "Salary: $80,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Software Engineer\n" + "Salary: $92,500\n");
        jobs.add("Location: New York, NY\n" + "Job: Front-End Developer\n" + "Salary: $85,000\n");
        jobs.add("Location: New York, NY\n" + "Job: Full Stack Developer\n" + "Salary: $105,500\n");
        jobs.add("Location: New York, NY\n" + "Job: Back-End Developer\n" + "Salary: $95,000\n");

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

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}