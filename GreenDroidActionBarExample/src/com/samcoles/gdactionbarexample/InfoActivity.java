package com.samcoles.gdactionbarexample;

import greendroid.app.GDActivity;
import android.os.Bundle;

public class InfoActivity extends GDActivity {
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	 	setActionBarContentView(R.layout.main);
	 	
	 	setTitle(R.string.info_activity_title);
	 }

}
