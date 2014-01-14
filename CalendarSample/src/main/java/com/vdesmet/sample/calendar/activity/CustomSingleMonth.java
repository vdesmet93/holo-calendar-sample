package com.vdesmet.sample.calendar.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.vdesmet.lib.calendar.CalendarView;
import com.vdesmet.lib.calendar.OnDayClickListener;
import com.vdesmet.sample.calendar.R;
import com.vdesmet.sample.calendar.activity.adapter.CustomDayAdapter;

import java.util.Calendar;

public class CustomSingleMonth extends ActionBarActivity implements OnDayClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        // Retrieve the CalendarView
        final CalendarView singleMonth = (CalendarView) findViewById(R.id.single_calendar);

        // Set the first valid day
        final Calendar firstValidDay = Calendar.getInstance();
        firstValidDay.set(Calendar.DAY_OF_MONTH, 1);
        singleMonth.setFirstValidDay(firstValidDay);

        // Create adapter
        final CustomDayAdapter adapter = new CustomDayAdapter();

        // Set listener and adapter
        singleMonth.setOnDayClickListener(this);
        singleMonth.setDayAdapter(adapter);
    }

    @Override
    public void onDayClick(final long dayInMillis) {

        Toast.makeText(this, getString(R.string.changing_selected_day_bold), Toast.LENGTH_SHORT).show();

    }
}
