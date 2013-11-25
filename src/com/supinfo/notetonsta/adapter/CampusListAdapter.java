package com.supinfo.notetonsta.adapter;

import java.util.List;

import com.supinfo.notetonsta.entity.Campus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author Charlie
 * @version 1.0
 *
 */
public class CampusListAdapter extends BaseAdapter {

	private Context context = null;
	private List<Campus> campus = null;
	
	public CampusListAdapter(Context context, List<Campus> campus) {
		super();
		this.context = context;
		this.campus = campus;
	}

	public int getCount() {
		return this.campus.size();
	}

	public Campus getItem(int position) {
		return campus.get(position);
	}

	public long getItemId(int position) {
		return getItem(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
	
		TextView view = new TextView(context);
		if(position % 2 == 0)
			view.setBackgroundColor(parent.getResources().getColor(android.R.color.secondary_text_light));
		else
			view.setBackgroundColor(parent.getResources().getColor(android.R.color.black));
		view.setTextSize(20);
		view.setText(getItem(position).getName());
		return view;
	}

}
