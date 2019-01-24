package ru.eskendarov.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    private final String LOG_TAG = "myLogs";

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment1, null);
        final Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Log.d(LOG_TAG, "Button click in Fragment1");
                Toast.makeText(getContext(), "Button click in FRAGMENT1",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}