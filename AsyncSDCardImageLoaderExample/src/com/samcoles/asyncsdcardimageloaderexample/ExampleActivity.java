package com.samcoles.asyncsdcardimageloaderexample;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ExampleActivity extends Activity {
	
	//CONSTANTS:	
	
	public static final int REQ_CODE_PICK_IMAGE = 1;
		
	
	//MEMBERS:
	
	private final SDImageLoader mImageLoader = new SDImageLoader();

	
	//METHODS:
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);
        
        //call pickImage() when view is clicked
        ImageView image = (ImageView)findViewById(R.id.image_viewer_image);
        image.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				pickImage();
			}
		});

        pickImage();
    }
    
    private void pickImage() {
    	Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(i, REQ_CODE_PICK_IMAGE);		
	}

	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) { 
	    super.onActivityResult(requestCode, resultCode, i); 

	    switch(requestCode) { 
	    case REQ_CODE_PICK_IMAGE:
	        if(resultCode == RESULT_OK){  
	        	//Get the filepath of the returned image
	            Uri selectedImage = i.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };
	            Cursor c = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
	            if(c == null) return;            	
	            c.moveToFirst();
	            int columnIndex = c.getColumnIndex(filePathColumn[0]);
	            String imagePath = c.getString(columnIndex);
	            c.close();
	            
	            //get a reference to the ImageView and using the SDImageLoader to load the selected image
	            ImageView image = (ImageView)findViewById(R.id.image_viewer_image);
	    		mImageLoader.load(this, imagePath, image, R.drawable.loading_placeholder);
	        }
	    }
	}
}