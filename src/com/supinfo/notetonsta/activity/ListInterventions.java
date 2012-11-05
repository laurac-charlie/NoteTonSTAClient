package com.supinfo.notetonsta.activity;

import java.util.ArrayList;

import com.supinfo.notetonsta.adapter.InterventionListAdapter;
import com.supinfo.notetonsta.entity.Campus;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.parser.JSONParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListInterventions extends Activity {

	private ArrayList<Intervention> list_intervention = new ArrayList<Intervention>();
	private InterventionListAdapter adapter = null;
	private Campus currentCampus = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventions);
        
        Bundle extras = getIntent().getExtras();
        loadListInterventions(extras);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_retour, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.menu_retour:
               finish();
               return true;
           default:
              return false;
        }
    }

	private void loadListInterventions(Bundle extras) {
		TextView title = (TextView) findViewById(R.id.title_interventions);
        
		if(extras != null)
		{
			this.currentCampus = (Campus) extras.get("theCampus");
			title.setText("These are all the interventions from " + this.currentCampus.getName() + ".\nPick one to evaluate it.");
		}
        
		this.list_intervention = JSONParser.getCampusInterventions(this.currentCampus);
		if(this.list_intervention != null)
		{
	        this.adapter = new InterventionListAdapter(this, this.list_intervention);
			ListView list = (ListView) findViewById(R.id.listViewIntervention);
			list.setAdapter(this.adapter);
			list.setOnItemClickListener(clickListener);
		}
		else
		{
			title.setText("There is no interventions from " + this.currentCampus.getName() + ".");
		}
	}
    
    private OnItemClickListener clickListener = new OnItemClickListener() 
    {
		public void onItemClick(AdapterView<?> prent, View v, int position,long id) 
		{
			Intent intent = new Intent(ListInterventions.this,DetailIntervention.class);
			intent.putExtra("theIntervention", ListInterventions.this.list_intervention.get(position).getId());
			startActivity(intent);
		}
	};

}
