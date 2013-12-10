package com.vdesmet.sample.calendar.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.vdesmet.lib.calendar.MultiCalendarView;
import com.vdesmet.sample.calendar.R;

import java.util.Calendar;

public class SimpleMultiMonth extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        // Retrieve the CalendarView
        MultiCalendarView multiMonth = (MultiCalendarView) findViewById(R.id.multi_calendar);

        // Set the first valid day
        final Calendar firstValidDay = Calendar.getInstance();
        multiMonth.setFirstValidDay(firstValidDay);

        // Set the last valid day
        final Calendar lastValidDay = Calendar.getInstance();
        lastValidDay.add(Calendar.MONTH, 3);
        multiMonth.setLastValidDay(lastValidDay);
    }
}
