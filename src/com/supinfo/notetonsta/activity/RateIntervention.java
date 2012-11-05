package com.supinfo.notetonsta.activity;

import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.Mark;
import com.supinfo.notetonsta.parser.JSONParser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RateIntervention extends Activity {

	private Intervention currentIntervention = null;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluate);
        
        Bundle extras = getIntent().getExtras();
        if(extras != null)
		{
        	this.currentIntervention = (Intervention) extras.get("intervention");
		}
        
        Button btn = (Button) findViewById(R.id.submit);
		btn.setOnClickListener(this.submitListener);
        
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_retour, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.menu_retour:
        	   setResult(RESULT_CANCELED);
               finish();
               return true;
           default:
              return false;
        }
    }
    
    private OnClickListener submitListener = new OnClickListener() {
		public void onClick(View view) {
			if(RateIntervention.this.currentIntervention != null)
			{
				TextView idBooster = (TextView) findViewById(R.id.id_booster);
				TextView comments = (TextView) findViewById(R.id.rate_comments);
				
				if(idBooster.getText().toString().equals(""))
				{
					Toast t = Toast.makeText(RateIntervention.this, "Vous devez renseigner votre idBooster.", 400);
					t.show();
					idBooster.requestFocus();
					return;
				}
				
				Mark mark = new Mark(RateIntervention.this.currentIntervention,1000,this.caculSlideNote(),this.calculSpeakerNote(),comments.getText().toString());
				try
				{
					mark.setIdBooster(Integer.parseInt(idBooster.getText().toString()));
				}
				catch(NumberFormatException e){}
				
				getIntent().putExtra("markSent", JSONParser.sendMark(mark));
				getIntent().putExtra("theIntervention", RateIntervention.this.currentIntervention.getId());
				setResult(RESULT_OK, getIntent());
				finish();
			}
			else
			{
				setResult(RESULT_CANCELED);
				finish();
			}
		}
		
		private float calculSpeakerNote(){
			RatingBar rate_knowledge = (RatingBar) findViewById(R.id.rate_knowledge);
			RatingBar rate_ability = (RatingBar) findViewById(R.id.rate_ability);
			RatingBar rate_answer = (RatingBar) findViewById(R.id.rate_answer);
			float res = rate_knowledge.getRating() + rate_ability.getRating() + rate_answer.getRating();
			res = res/3;
			return res;
		}
		private float caculSlideNote(){
			RatingBar rate_content = (RatingBar) findViewById(R.id.rate_content);
			RatingBar rate_format = (RatingBar) findViewById(R.id.rate_format);
			RatingBar rate_example = (RatingBar) findViewById(R.id.rate_example);
			float res = rate_content.getRating() + rate_format.getRating() + rate_example.getRating();
			res = res/3;
			return res;
		}
	};
}
