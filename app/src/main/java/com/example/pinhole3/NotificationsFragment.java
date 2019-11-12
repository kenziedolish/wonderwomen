package com.example.pinhole3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pinhole3.MyRecyclerViewAdapter;
import com.example.pinhole3.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        ImageButton courseraButton = (ImageButton) root.findViewById(R.id.courseraButton);
        courseraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursera.com"));
                startActivity(browserIntent);
            }

        });


        ImageButton edxButton = (ImageButton) root.findViewById(R.id.edxButton);
        edxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.edx.com"));
                startActivity(browserIntent);
            }

        });


        ImageButton linkedInButton = (ImageButton) root.findViewById(R.id.linkedInButton);
        linkedInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com"));
                startActivity(browserIntent);
            }

        });


        ImageButton treehouseButton = (ImageButton) root.findViewById(R.id.treehouseButton);
        treehouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.teamtreehouse.com"));
                startActivity(browserIntent);
            }

        });




        return root;

    }
}

