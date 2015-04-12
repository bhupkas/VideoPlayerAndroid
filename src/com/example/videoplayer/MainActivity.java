package com.example.videoplayer;


import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	private Button btnDisplay;
	private String str;
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        addListenerOnButton();
    }  
    public void addListenerOnButton() {
  	  
        final Context context = this;  
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
    	btnDisplay.setOnClickListener(new OnClickListener() {
     
    		@Override
    		public void onClick(View v) {
    				String str = Environment.getExternalStorageDirectory().getPath()+"/Download/v1.mp4";
    			    Intent intent = new Intent(context, listing.class);
    			    str = Environment.getExternalStorageDirectory().getPath()+"/Download/v1.mp4"; 
    			    intent.putExtra("name",str);
                    startActivity(intent);   
    		}
     
    	});
     
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
