package com.bones.simplefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }

    FragmentManager fm;
    Fragment two;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button next = (Button) view.findViewById(R.id.btnNextFrag1);
        two = new TwoFragment();
        fm = getChildFragmentManager();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().add(R.id.oneContainer,two).addToBackStack(null).commit();
            }
        });

        return view;
    }


}
