package com.example.leomorales.testswitchfragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity
        implements FragmentB.OnItemSelectedListener,
                    FragmentA.OnFragmentAEventsListener{
    private final String TAG = "MainActivity";
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            fragmentA = FragmentA.newInstance("fragment A");
            fragmentB = FragmentB.newInstance("fragment B");
        }

        displayFragmentA();
    }

    // Replace the switch method
    protected void displayFragmentA() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (fragmentA.isAdded()) { // if the fragment is already in container
            ft.show(fragmentA);
        } else { // fragment needs to be added to frame container
            ft.add(R.id.fragment_place, fragmentA, "A");
        }
        // Hide fragment B
        if (fragmentB.isAdded()) { ft.hide(fragmentB); }
        // Commit changes
        ft.commit();
    }

    // Replace the switch method
    protected void displayFragmentB() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (fragmentB.isAdded()) { // if the fragment is already in container
            ft.show(fragmentB);
        } else { // fragment needs to be added to frame container
            ft.add(R.id.fragment_place, fragmentB, "B");
        }
        // Hide fragment A
        if (fragmentA.isAdded()) { ft.hide(fragmentA); }
        // Commit changes
        ft.commit();
    }

    @Override
    public void onButtonPressed() {
        displayFragmentA();
    }

    @Override
    public void onButtonOptionPressed(String opcion) {
        Log.d(TAG, "onButtonOptionPressed: Opcion seleccionada: "+opcion);
        fragmentA.update_titulo(opcion);
        displayFragmentA();
    }

    @Override
    public void onClickButtonIrAB() {
        displayFragmentB();
    }
}
