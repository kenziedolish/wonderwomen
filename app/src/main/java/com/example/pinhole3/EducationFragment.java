package com.example.pinhole3;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class EducationFragment extends Fragment {

    ImageButton coursera_button, edxButton, linkedInButton,treehouseButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_education, container, false);


        coursera_button = (ImageButton) root.findViewById(R.id.coursera_button);
        edxButton = (ImageButton) root.findViewById(R.id.edx_button);
        linkedInButton = (ImageButton) root.findViewById(R.id.linkedIn_button);
        treehouseButton = (ImageButton) root.findViewById(R.id.treehouse_button);


        coursera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursera.com"));
                startActivity(browserIntent);
            }
        });


        edxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.edx.com"));
                startActivity(browserIntent);
            }
        });


        linkedInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com"));
                startActivity(browserIntent);
            }
        });


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