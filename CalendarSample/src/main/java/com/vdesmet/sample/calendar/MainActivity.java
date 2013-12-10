package com.vdesmet.sample.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.vdesmet.sample.calendar.activity.SimpleMultiMonth;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, SimpleMultiMonth.class));
    }
}
