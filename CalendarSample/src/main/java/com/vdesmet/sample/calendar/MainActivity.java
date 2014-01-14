package com.vdesmet.sample.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vdesmet.sample.calendar.activity.CustomMultiMonth;
import com.vdesmet.sample.calendar.activity.CustomSingleMonth;
import com.vdesmet.sample.calendar.activity.SimpleMultiMonth;
import com.vdesmet.sample.calendar.activity.SimpleSingleMonth;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.activity_main_listview);
        listView.setAdapter(new ListAdapter(this));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
        switch(position) {
            case ListAdapter.POS_SIMPLE_SINGLE:
                startActivity(new Intent(this, SimpleSingleMonth.class));
                break;

            case ListAdapter.POS_SIMPLE_MULTI:
                startActivity(new Intent(this, SimpleMultiMonth.class));
                break;

            case ListAdapter.POS_CUSTOM_SINGLE:
                startActivity(new Intent(this, CustomSingleMonth.class));
                break;

            case ListAdapter.POS_CUSTOM_MULTI:
                startActivity(new Intent(this, CustomMultiMonth.class));
                break;
        }
    }
}
