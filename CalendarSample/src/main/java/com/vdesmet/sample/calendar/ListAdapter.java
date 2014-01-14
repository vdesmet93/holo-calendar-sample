package com.vdesmet.sample.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.InputMismatchException;

public class ListAdapter extends BaseAdapter {

    public static final int POS_COUNT = 4;
    public static final int POS_SIMPLE_SINGLE = 0;
    public static final int POS_SIMPLE_MULTI = 1;
    public static final int POS_CUSTOM_SINGLE = 2;
    public static final int POS_CUSTOM_MULTI = 3;

    private final LayoutInflater mInflater;

    public ListAdapter(final Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return POS_COUNT;
    }

    @Override
    public Object getItem(final int position) {
        return null;
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final View contentView;
        if(convertView != null) {
            contentView = convertView;
        } else {
            contentView = mInflater.inflate(R.layout.main_list_item, parent, false);
        }

        // Set the title
        final TextView textView = (TextView) contentView.findViewById(R.id.main_list_item_title);
        textView.setText(getTitleForPosition(position));

        return contentView;
    }

    private int getTitleForPosition(final int position) {
        switch(position) {
            case POS_SIMPLE_SINGLE:
                return R.string.list_title_simple_single;

            case POS_SIMPLE_MULTI:
                return R.string.list_title_simple_multi;

            case POS_CUSTOM_SINGLE:
                return R.string.list_title_custom_single;

            case POS_CUSTOM_MULTI:
                return R.string.list_title_custom_multi;

            default:
                throw new InputMismatchException("Invalid position. No known title");
        }
    }
}
