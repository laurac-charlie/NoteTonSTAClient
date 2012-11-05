package com.supinfo.notetonsta.activity;

import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.parser.JSONParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class DetailIntervention extends Activity {

	protected static final int ACTIVITY_CODE = 1;
	private Intervention currentIntervention = null;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        
        Bundle extras = getIntent().getExtras();
        this.loadIntervention(extras);
        
        /*android.widget.Button btn = (android.widget.Button) findViewById(R.id.btnRate);
		btn.setOnClickListener(this.clickListener);*/
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_rate, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.menu_rate:
        	   clickListener.onClick(getCurrentFocus());
              return true;
           case R.id.menu_retour:
               finish();
               return true;
           default:
              return false;
        }
    }

	private void loadIntervention(Bundle extras) {
		TextView subject = (TextView) findViewById(R.id.txt_subject);
        TextView title = (TextView) findViewById(R.id.txt_campus);
        TextView from_date = (TextView) findViewById(R.id.txt_from);
        TextView to_date = (TextView) findViewById(R.id.txt_To);
        TextView description = (TextView) findViewById(R.id.txt_description);
        TextView nb_mark = (TextView) findViewById(R.id.txt_nbMark);
        TextView speaker_mark = (TextView) findViewById(R.id.txt_spMark);
        TextView slide_mark = (TextView) findViewById(R.id.txt_slMark);
        TextView global_mark = (TextView) findViewById(R.id.txt_glMark);
        
        if(extras != null)
		{
        	this.currentIntervention = JSONParser.getIntervention(extras.getInt("theIntervention"));
        	if (this.currentIntervention != null)
        	{
	        	subject.setText(this.currentIntervention.getSubject());
	        	title.setText(this.currentIntervention.getCampus().getName());
	        	from_date.setText(this.currentIntervention.getBeginDate().toString());
	        	to_date.setText(this.currentIntervention.getEndDate().toString());
	        	description.setText(this.currentIntervention.getDescription());
	        	if (this.currentIntervention.getMarks() != null)
	        	{
		        	nb_mark.setText(Integer.toString( this.currentIntervention.getNumberOfMark()));
		        	speaker_mark.setText(Float.toString(this.currentIntervention.getAverageSpeakerNote()));
		        	slide_mark.setText(Float.toString(this.currentIntervention.getAverageSlideNote()));
		        	global_mark.setText(Float.toString(this.currentIntervention.getAverageMark()));
	        	}
        	}
		}
	}

	private OnClickListener clickListener = new OnClickListener() {
		public void onClick(View view) {
			if(DetailIntervention.this.currentIntervention != null)
			{
				Intent intent = new Intent(DetailIntervention.this,RateIntervention.class);
				intent.putExtra("intervention",DetailIntervention.this.currentIntervention);
				startActivityForResult(intent, ACTIVITY_CODE);
			}
			else
			{
				Toast t = Toast.makeText(DetailIntervention.this, "No intervention loaded.", 400);
				t.show();
			}
		}
	};

	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case ACTIVITY_CODE:
			switch (resultCode) {
			case RESULT_CANCELED:
				Toast.makeText(this, "La notation a été annulé.", 400).show();
				break;
			case RESULT_OK:
				if(data.getExtras().getBoolean("markSent"))
				{
					Toast.makeText(this, "Votre notation a bien été pris en compte.", 400).show();
					loadIntervention(data.getExtras());
				}
				else
				{
					Toast t = Toast.makeText(this, "La note n'a pas pu être envoyé.", 400);
					t.show();
				}
				break;
			default:
				break;
			}
		default:
			break;
		}
	}

}
