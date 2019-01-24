package ru.eskendarov.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Fragment frag2 = new Fragment2();
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment2, frag2);
        fragmentTransaction.commit();
        Log.d(LOG_TAG, "MainActivity onCreate");
    }

    public void onClick(final View view) {
        final Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView))
                .setText("Доступ к фрагменту 1 из Activity");
        final Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
        ((TextView) frag2.getView().findViewById(R.id.textView2))
                .setText("Доступ к фрагменту 2 из Activity");
        Toast.makeText(getApplicationContext(), "Access to Frag from Activity",
                Toast.LENGTH_SHORT).show();
    }

}