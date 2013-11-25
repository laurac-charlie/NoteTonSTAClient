package com.supinfo.notetonsta.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.supinfo.notetonsta.activity.R;
import com.supinfo.notetonsta.entity.Intervention;

/**
 * 
 * @author Charlie
 * @version 1.0
 *
 */
public class InterventionListAdapter extends BaseAdapter {

	private Context context = null;
	private List<Intervention> interventions = null;
	private LayoutInflater mInflater = null;

	public InterventionListAdapter(Context context,
			List<Intervention> interventions) {
		super();
		this.context = context;
		this.interventions = interventions;
		mInflater = LayoutInflater.from(this.context);
	}

	public int getCount() {
		return this.interventions.size();
	}

	public Intervention getItem(int position) {
		return interventions.get(position);
	}

	public long getItemId(int position) {
		return getItem(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		/*
		 * TextView view = new TextView(context); if(position % 2 == 0)
		 * view.setBackgroundColor
		 * (parent.getResources().getColor(android.R.color
		 * .secondary_text_light)); else
		 * view.setBackgroundColor(parent.getResources
		 * ().getColor(android.R.color.black)); view.setTextSize(20);
		 * view.setText(getItem(position).getSubject()); return view;
		 */

		LinearLayout layoutItem;
		if (convertView == null) 
			layoutItem = (LinearLayout) mInflater.inflate(R.layout.itemtemplate, parent, false);
		else
			layoutItem = (LinearLayout) convertView;

		TextView subject = (TextView) layoutItem.findViewById(R.id.item_subject);
		TextView state = (TextView) layoutItem.findViewById(R.id.item_state);
		TextView period = (TextView) layoutItem.findViewById(R.id.item_period);
		subject.setTextColor(Color.WHITE);
		state.setTextColor(Color.WHITE);
		period.setTextColor(Color.WHITE);

		subject.setText(this.interventions.get(position).getSubject());
		state.setText("is " + this.interventions.get(position).getStatus().toLowerCase());
		period.setText("From : " + this.interventions.get(position).getBeginDate().toString() + " to : " + this.interventions.get(position).getEndDate().toString());

		if (position % 2 == 0)
			layoutItem.setBackgroundColor(Color.DKGRAY);
		else
			layoutItem.setBackgroundColor(Color.BLACK);
		
		return layoutItem;
	}
}
