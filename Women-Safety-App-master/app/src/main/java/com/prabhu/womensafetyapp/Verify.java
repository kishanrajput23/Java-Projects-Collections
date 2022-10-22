package com.prabhu.womensafetyapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public class Verify extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verify);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		
	}
	
	
	public void verify_no(View v) {	
		EditText source_no = (EditText) this.findViewById(R.id.editText1);
		String str_source_no=source_no.getText().toString();
		SQLiteDatabase db;
		db=openOrCreateDatabase("NumDB", Context.MODE_PRIVATE, null);
	//	if(source_no.getText()!=null){
		
		db.execSQL("CREATE TABLE IF NOT EXISTS source(number VARCHAR);");
		db.execSQL("INSERT INTO source VALUES('"+str_source_no+"');");
		Toast.makeText(getApplicationContext(), str_source_no+" Successfully Saved",Toast.LENGTH_SHORT).show();
		db.close();
		back(v);
//		}
//		else{
//			Toast.makeText(getApplicationContext(), "Enter Your Number.",Toast.LENGTH_SHORT).show();
	//	}
	}
	
	
	
	
	
	

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.verify, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void back(View v) {
		Intent i_back=new Intent(Verify.this,MainActivity.class);
		startActivity(i_back);
			
		}

}
