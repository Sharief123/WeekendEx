package com.example.weekendex;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private int[] images = {R.drawable.svsc,R.drawable.sgs,R.drawable.k150,
            R.drawable.gs,R.drawable.duk,R.drawable.ascr,R.drawable.jlk,
            R.drawable.cmgr};

    private String[] names = {"SVSC","SGS","K150","GS","Duk","ASVR","JLK","CMGR"};


    private Spinner spinner;

    ArrayAdapter<CharSequence> adapter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FirstAdapter firstAdapter;
    private List<Director> list = new ArrayList<>();

    private Context context;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        context = getActivity();
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.movies_names,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        DirectorsList();
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        //list = Arrays.asList(getResources().getStringArray(R.array.movies_names));
        firstAdapter = new FirstAdapter(list,context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firstAdapter);
        recyclerView.setHasFixedSize(true);
        return view;
    }
    private void DirectorsList()
    {
        int count = 0;
        for (String name : names )
        {
            Director dir = new Director(images[count], name);
            list.add(dir);
            count++;
        }
    }
}
