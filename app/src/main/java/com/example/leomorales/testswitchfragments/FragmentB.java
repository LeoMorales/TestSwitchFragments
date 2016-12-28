package com.example.leomorales.testswitchfragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by leomorales on 27/12/16.
 */

public class FragmentB extends Fragment {

    private View rootView;

    // ...
    // Define the listener of the interface type
    // listener will the activity instance containing fragment
    private OnItemSelectedListener listener;
    private Button button_ir_a_a;
    private Button button_opcion_1;
    private Button button_opcion_2;
    private Button button_opcion_3;

    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity

        //...
        // Avisar cuando presionen el boton principal:
        public void onButtonPressed();
        // Avisar cuando selecciones una opcion:
        public void onButtonOptionPressed( String opcion);
    }

    public static FragmentB newInstance(String someTitle) {
        FragmentB fragmentDemo = new FragmentB();
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
        // El titulo no se usa, es para probar el paso de argumentos...
    }

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_b, container, false);
        button_ir_a_a = (Button) rootView.findViewById(R.id.button_ir_a_a);
        button_opcion_1 = (Button) rootView.findViewById(R.id.opcion_1);
        button_opcion_2 = (Button) rootView.findViewById(R.id.opcion_2);
        button_opcion_3 = (Button) rootView.findViewById(R.id.opcion_3);
        button_ir_a_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonIrAA(view);
            }
        });
        button_opcion_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonOpcion1(view, "Opcion 1");
            }
        });
        button_opcion_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonOpcion1(view, "Opcion 2");
            }
        });
        button_opcion_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonOpcion1(view, "Opcion 3");
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    // Now we can fire the event when the user selects something in the fragment
    public void clickButtonIrAA(View v) {
        listener.onButtonPressed();
    }

    public void clickButtonOpcion1(View v, String opcion) {
        listener.onButtonOptionPressed(opcion);
    }
}
