package com.example.githubproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class WorkOutFragment extends Fragment {
    public static WorkOutFragment newInstance(String param1, String param2) {
        WorkOutFragment fragment = new WorkOutFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    Button btn_chest;
    Button btn_back;
    Button btn_shoulder;
    Button btn_lower_body;
    Button btn_abs;
    Button btn_arm;
    ListView WL;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_out, container, false);

        btn_chest = view.findViewById(R.id.btn_chest);
        btn_back = view.findViewById(R.id.btn_back);
        btn_shoulder = view.findViewById(R.id.btn_shoulder);
        btn_lower_body = view.findViewById(R.id.btn_lower_body);
        btn_abs = view.findViewById(R.id.btn_abs);
        btn_arm = view.findViewById(R.id.btn_arm);
        WL = view.findViewById(R.id.WorkOutList);
        displayList();

        btn_chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayList();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_lower_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
    void displayList() {
        DBHelper helper = new DBHelper(getContext(), 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT Exercise_Name FROM 운동목록", null);
        ListViewAdapter item = new ListViewAdapter();

        while(cursor.moveToNext()) {
            item.plusItem(cursor.getString(0));
        }
        WL.setAdapter(item);
    }
}