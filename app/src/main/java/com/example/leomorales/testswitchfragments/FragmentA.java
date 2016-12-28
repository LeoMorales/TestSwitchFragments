package com.example.leomorales.testswitchfragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by leomorales on 27/12/16.
 */

public class FragmentA extends Fragment {

    private View rootView;

    private OnFragmentAEventsListener listener;
    private Button button_ir_a_b;
    private TextView titulo_fragment;

    public void update_titulo(String titulo) {
        /* Actualiza el titulo del fragment */
        titulo_fragment.setText(titulo);
    }

    // Define the events that the fragment will use to communicate
    public interface OnFragmentAEventsListener {
        // This can be any number of events to be sent to the activity

        // Avisar cuando cliqueen en el boton para ir a B:
        public void onClickButtonIrAB();
    }


    public static FragmentA newInstance(String someTitle) {
        FragmentA fragmentDemo = new FragmentA();
        Bundle args = new Bundle();
        args.putString("title", someTitle);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get back arguments
        String title = getArguments().getString("title", "");
    }

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_a, container, false);
        titulo_fragment = (TextView) rootView.findViewById(R.id.titulo_fragment_a);
        button_ir_a_b = (Button) rootView.findViewById(R.id.button_ir_a_b);
        button_ir_a_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOnIrAA(view);
            }
        });
        return rootView;
    }

    // Store the listener (activity) that will have events fired once the fragment is attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAEventsListener) {
            listener = (OnFragmentAEventsListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    // Now we can fire the event when the user selects something in the fragment
    public void onClickOnIrAA(View v) {
        listener.onClickButtonIrAB();
    }
}
