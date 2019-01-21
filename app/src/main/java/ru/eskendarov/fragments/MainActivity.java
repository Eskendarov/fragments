package ru.eskendarov.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {

    private final String LOG_TAG = "myLogs";
    private Fragment1 frag1;
    private Fragment2 frag2;
    private FragmentTransaction fragmentTransaction;
    private CheckBox chbStack;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();

        chbStack = findViewById(R.id.chbStack);
        Log.d(LOG_TAG, "MainActivity onCreate");
    }

    public void onClick(final View v) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                fragmentTransaction.add(R.id.frgmCont, frag1);
                Log.i(LOG_TAG, "add " + frag1);
                break;
            case R.id.btnRemove:
                fragmentTransaction.remove(frag1);
                Log.i(LOG_TAG, "remove " + frag2);
                break;
            case R.id.btnReplace:
                fragmentTransaction.replace(R.id.frgmCont, frag2);
                Log.i(LOG_TAG, "replace " + frag2);
            default:
                break;
        }

        if (chbStack.isChecked()) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity onDestroy");
    }

}