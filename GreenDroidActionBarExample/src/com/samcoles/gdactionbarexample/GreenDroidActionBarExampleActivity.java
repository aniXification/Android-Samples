package com.samcoles.gdactionbarexample;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem;
import greendroid.widget.ActionBarItem.Type;
import android.content.Intent;
import android.os.Bundle;

public class GreenDroidActionBarExampleActivity extends GDActivity {
	
	private static final int ACTION_BAR_INFO = 0;
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarContentView(R.layout.main);
        
        addActionBarItem(Type.Info, ACTION_BAR_INFO);
    }

	@Override
	public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
		switch(item.getItemId()) {
		case ACTION_BAR_INFO:
			startActivity(new Intent(this, InfoActivity.class));
			break;
		default:
			return super.onHandleActionBarItemClick(item, position);
		}
		return true;
	}
}