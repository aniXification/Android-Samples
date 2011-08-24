package com.samcoles.dashboardexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DashboardExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        //attach event handler to dash buttons
        DashboardClickListener dBClickListener = new DashboardClickListener();
        findViewById(R.id.dashboard_button_one).setOnClickListener(dBClickListener);
        findViewById(R.id.dashboard_button_two).setOnClickListener(dBClickListener);
        findViewById(R.id.dashboard_button_three).setOnClickListener(dBClickListener);
        findViewById(R.id.dashboard_button_four).setOnClickListener(dBClickListener);
        findViewById(R.id.dashboard_button_five).setOnClickListener(dBClickListener);
        findViewById(R.id.dashboard_button_six).setOnClickListener(dBClickListener);
    }
    
    
    //	examples below all open another DashboardExampleActivity!   //
    //	this will need to be modified for each button to open		//
    //	your activity that corresponds to each button				//
    private class DashboardClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = null;
            switch (v.getId()) {
                case R.id.dashboard_button_one:
                    i = new Intent(DashboardExampleActivity.this, DashboardExampleActivity.class);
                    break;
                case R.id.dashboard_button_two:
                    i = new Intent(DashboardExampleActivity.this, DashboardExampleActivity.class);
                    break;
                case R.id.dashboard_button_three:
                    i = new Intent(DashboardExampleActivity.this, DashboardExampleActivity.class);
                    break;
                case R.id.dashboard_button_four:
                    i = new Intent(DashboardExampleActivity.this, DashboardExampleActivity.class);
                    break;
                case R.id.dashboard_button_five:
                    i = new Intent(DashboardExampleActivity.this, DashboardExampleActivity.class);
                    break;
                case R.id.dashboard_button_six:
                    i = new Intent(DashboardExampleActivity.this, DashboardExampleActivity.class);
                    break;
                default:
                    break;
            }
            if(i != null) {
                startActivity(i);
            }
        }
    }
}