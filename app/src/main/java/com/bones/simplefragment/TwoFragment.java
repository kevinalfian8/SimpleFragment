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
public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }

    Fragment three;
    FragmentManager fm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        three = new ThreeFragment();
        fm = getChildFragmentManager();
        Button next = (Button) view.findViewById(R.id.btnNextFrag2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().add(R.id.twoContainer,three).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
