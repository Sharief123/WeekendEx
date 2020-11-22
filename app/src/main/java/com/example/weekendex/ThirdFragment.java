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
public class ThirdFragment extends Fragment {

    private int[] images = {R.drawable.ssr,R.drawable.trivikram,R.drawable.sukumar,
                            R.drawable.vvn,R.drawable.rgv,R.drawable.puri,R.drawable.harishshankar,
                            R.drawable.venusriram,R.drawable.boyapati};

    private String[] names = {"S S Rajamouli","Trivikram","Sukumar","V V Nayank","Ram Gopala Varma","Puri","Harish Shankar","Venu SriRam","Boyapati"};

    private Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ThirdAdapter thirdAdapter;
    private List<Movies> list = new ArrayList<>();

    private Context context;


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_third, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_2);
        context = getActivity();

        spinner = view.findViewById(R.id.spinnerThrid);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.directors,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoviesList();
        spinner.setAdapter(adapter);


        layoutManager = new LinearLayoutManager(getActivity());
        //list = Arrays.asList(getResources().getStringArray(R.array.directors));
        thirdAdapter = new ThirdAdapter(list,context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(thirdAdapter);
        recyclerView.setHasFixedSize(true);
        return view;
    }
    private void MoviesList()
    {
        int count = 0;
        for (String name : names )
        {
            Movies mov = new Movies(images[count], name);
            list.add(mov);
            count++;
        }
    }
}
