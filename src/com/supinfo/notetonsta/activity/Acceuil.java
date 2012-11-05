package com.supinfo.notetonsta.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.supinfo.notetonsta.adapter.CampusListAdapter;
import com.supinfo.notetonsta.entity.Campus;
import com.supinfo.notetonsta.parser.JSONParser;
import java.util.ArrayList;

public class Acceuil extends Activity {
	
	private ArrayList<Campus> list_campus = new ArrayList<Campus>();
	private CampusListAdapter adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.list_campus = JSONParser.getAllCampus();
        //XMLParser.getAllCampus();
        
        this.adapter = new CampusListAdapter(this, this.list_campus);
		ListView listview = (ListView) findViewById(R.id.listViewCampus);
		listview.setAdapter(this.adapter);
		listview.setOnItemClickListener(clickListener);
    }
    
    private OnItemClickListener clickListener = new OnItemClickListener() 
    {
		public void onItemClick(AdapterView<?> prent, View v, int position,long id) 
		{
			Intent intent = new Intent(Acceuil.this,ListInterventions.class);
			intent.putExtra("theCampus", Acceuil.this.list_campus.get(position));
			startActivity(intent);
		}
	};
}