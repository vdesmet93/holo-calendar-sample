package com.vdesmet.sample.calendar.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.vdesmet.lib.calendar.MultiCalendarView;
import com.vdesmet.lib.calendar.OnDayClickListener;
import com.vdesmet.sample.calendar.R;
import com.vdesmet.sample.calendar.activity.adapter.CustomDayAdapter;

import java.util.Calendar;

public class CustomMultiMonth extends ActionBarActivity implements OnDayClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        // Retrieve the CalendarView
        final MultiCalendarView multiMonth = (MultiCalendarView) findViewById(R.id.multi_calendar);

        // Set the first valid day
        final Calendar firstValidDay = Calendar.getInstance();
        firstValidDay.set(Calendar.DAY_OF_MONTH, 1);
        multiMonth.setFirstValidDay(firstValidDay);

        // Set the last valid day
        final Calendar lastValidDay = Calendar.getInstance();
        lastValidDay.add(Calendar.MONTH, 12 * 3); // 3 years
        multiMonth.setLastValidDay(lastValidDay);

        // Create adapter
        final CustomDayAdapter adapter = new CustomDayAdapter();

        // Set listener and adapter
        multiMonth.setOnDayClickListener(this);
        multiMonth.setDayAdapter(adapter);
    }

    @Override
    public void onDayClick(final long dayInMillis) {

        Toast.makeText(this, getString(R.string.changing_selected_day_bold), Toast.LENGTH_SHORT).show();

    }
}
