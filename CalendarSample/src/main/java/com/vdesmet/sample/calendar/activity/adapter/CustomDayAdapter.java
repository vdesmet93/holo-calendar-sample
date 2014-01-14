package com.vdesmet.sample.calendar.activity.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import com.vdesmet.lib.calendar.DayAdapter;

import java.util.Calendar;
import java.util.Random;

public class CustomDayAdapter implements DayAdapter {
    private static final int[][] CATEGORY_COLORS = {
            null, null, null,
            { Color.BLUE },
            { Color.RED },
            { Color.GREEN, Color.RED },
            { Color.CYAN, Color.GREEN, Color.RED, Color.BLUE, Color.BLACK }
    };

    private final Random mRandom;
    private final long mToday;

    public CustomDayAdapter() {
        mRandom = new Random();

        // Get the time in millis of today
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        mToday = calendar.getTimeInMillis();
    }

    @Override
    public int[] getCategoryColors(final long dayInMillis) {
        // Fill the category colors with random int arrays.
        final int index = mRandom.nextInt(CATEGORY_COLORS.length);
        return CATEGORY_COLORS[index];
    }

    @Override
    public boolean isDayEnabled(final long dayInMillis) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dayInMillis);

        // Disable all saturdays
        return calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY;
    }

    @Override
    public void updateTextView(final TextView dateTextView, final long dayInMillis) {
        if(mToday == dayInMillis) {
            // Do something with the selected date
            dateTextView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        // else, we don't need to update the TextView
    }

    @Override
    public void updateHeaderTextView(final TextView header, final int dayOfWeek) {
        switch(dayOfWeek) {
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                header.setTextColor(Color.RED);
                break;

            default:
                header.setTextColor(Color.BLUE);
                break;
        }
    }
}
