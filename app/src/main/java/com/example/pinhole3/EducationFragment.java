package com.example.pinhole3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class EducationFragment extends Fragment {


    MyRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_trainings, container, false);


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

    public void onItemClick(View view, int position) {
        Toast.makeText(this.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

//    public void goToUrl(Button b) {
//        String url="";
//        Intent intent = new Intent(Intent.ACTION_VIEW);
////        switch(b.getId()) {
////            case R.id.courseraButton:
////                url = "http://www.coursera.com";
////                break;
////            case R.id.edxButton:
////                url = "http://www.edx.com";
////                break;
////            case R.id.linkedInButton:
////                url = "http://www.linkedin.com";
////                break;
////            case R.id.treehouseButton:
////                url = "http://www.teamtreehouse.com";
////                break;
////        }
//        intent.setData(Uri.parse(url));
//        startActivity(intent);
//    }


}