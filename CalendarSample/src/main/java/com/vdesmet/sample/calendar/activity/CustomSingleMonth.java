package com.vdesmet.sample.calendar.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.vdesmet.lib.calendar.CalendarView;
import com.vdesmet.lib.calendar.OnDayClickListener;
import com.vdesmet.sample.calendar.R;
import com.vdesmet.sample.calendar.activity.adapter.CustomDayAdapter;

import java.util.Calendar;

public class CustomSingleMonth extends ActionBarActivity implements OnDayClickListener {
    private CalendarView mSingleMonth;

    private TextView mSelectedTextView;
    private Typeface mSelectedTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        // Retrieve the CalendarView
        mSingleMonth = (CalendarView) findViewById(R.id.single_calendar);

        // Set the first valid day
        final Calendar firstValidDay = Calendar.getInstance();
        firstValidDay.set(Calendar.DAY_OF_MONTH, 1);
        mSingleMonth.setFirstValidDay(firstValidDay);

        // Create adapter
        final CustomDayAdapter adapter = new CustomDayAdapter();

        // Set listener and adapter
        mSingleMonth.setOnDayClickListener(this);
        mSingleMonth.setDayAdapter(adapter);
    }
    @Override
    public void onDayClick(final long dayInMillis) {
        // Reset the previously selected TextView to his previous Typeface
        if(mSelectedTextView != null) {
            mSelectedTextView.setTypeface(mSelectedTypeface);
        }

        final TextView day = mSingleMonth.getTextViewForDate(dayInMillis);
        if(day != null) {
            // Remember the selected TextView and it's font
            mSelectedTypeface = day.getTypeface();
            mSelectedTextView = day;

            // Show the selected TextView as bold
            day.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

}