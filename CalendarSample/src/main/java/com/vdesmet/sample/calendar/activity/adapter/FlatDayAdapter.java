package com.vdesmet.sample.calendar.activity.adapter;

import android.graphics.Color;
import android.widget.TextView;

import com.vdesmet.lib.calendar.DayAdapter;

import java.util.Calendar;

public class FlatDayAdapter implements DayAdapter {

    @Override
    public int[] getCategoryColors(final long dayInMillis) {
        return null;
    }

    @Override
    public boolean isDayEnabled(final long dayInMillis) {
        return true;
    }

    @Override
    public void updateTextView(final TextView dateTextView, final long dayInMillis) {
    }

    @Override
    public void updateHeaderTextView(final TextView header, final int dayOfWeek) {
        switch(dayOfWeek) {
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                header.setTextColor(Color.RED);
                break;
        }
    }
}
