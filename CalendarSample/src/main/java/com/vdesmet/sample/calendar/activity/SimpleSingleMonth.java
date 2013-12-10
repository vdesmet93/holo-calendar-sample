package com.vdesmet.sample.calendar.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.vdesmet.lib.calendar.CalendarView;
import com.vdesmet.sample.calendar.R;

import java.util.Calendar;

public class SimpleSingleMonth extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        // Retrieve the CalendarView
        CalendarView singleMonth = (CalendarView) findViewById(R.id.single_calendar);

        // Set the first valid day
        final Calendar firstValidDay = Calendar.getInstance();
        firstValidDay.set(Calendar.DAY_OF_MONTH, 4);
        singleMonth.setFirstValidDay(firstValidDay);
    }
}
