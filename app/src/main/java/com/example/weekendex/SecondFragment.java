package com.example.weekendex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list = new ArrayList<>();
    private SecondAdapter secondAdapter;


    Context context;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second, container, false);
        context = getActivity();
        spinner = view.findViewById(R.id.spinnerSecond);
        recyclerView = view.findViewById(R.id.recyclerView_1);
        layoutManager = new LinearLayoutManager(getContext());
        list = Arrays.asList(getResources().getStringArray(R.array.heros_names));
        secondAdapter = new SecondAdapter(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(secondAdapter);
        recyclerView.setHasFixedSize(true);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.heros_names,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return view;
    }

}
