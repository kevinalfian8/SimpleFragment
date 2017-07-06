package com.bones.simplefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button showFrag1,showFrag2,removeFrag;
    FragmentManager fm;
    Fragment first,last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFrag2 = (Button) findViewById(R.id.showFrag2);


        first = new OneFragment();
        last = new ThreeFragment();
        fm = getSupportFragmentManager();



        fm.beginTransaction()
            .add(R.id.frameContainer,first)
            .commit();


        showFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Setting the fragment two to container
                first.getChildFragmentManager().beginTransaction()
                        .add(R.id.oneContainer,last)
                        .addToBackStack(null)
                        .commit();
            }
        });





    }

    @Override
    public void onBackPressed() {

        //first.getChildFragmentManager().popBackStackImmediate();
        //first = fm.findFragmentById(R.id.frameContainer);
        if(first.isVisible()){
            FragmentManager childfm = first.getChildFragmentManager();
            if (childfm.getBackStackEntryCount()>0){
                childfm.popBackStack();
                return;
            }else {
                super.onBackPressed();
            }
        }
        //for(int i = 0; i < total; i++) {
        //    first.getChildFragmentManager().popBackStack();
        //}
        //first.getChildFragmentManager().popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }
}
