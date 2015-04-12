package com.example.videoplayer;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listing extends ListActivity{

	private String str;
	String[] videoFileList = new String[1];
/*	
String[] videoFileList = {
	Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/v1.mp4",
	Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/v3.mp4"
};
*/

public class MyThumbnaildapter extends ArrayAdapter<String>{

 public MyThumbnaildapter(Context context, int textViewResourceId,
   String[] objects) {
  super(context, textViewResourceId, objects);
  // TODO Auto-generated constructor stub
  
//Item Click Listener for the listview
  OnItemClickListener itemClickListener = new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
          // Getting the Container Layout of the ListView
          LinearLayout linearLayoutParent = (LinearLayout) container;

          // Getting the inner Linear Layout
          LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);

          // Getting the Country TextView
          TextView tvCountry = (TextView) linearLayoutChild.getChildAt(0);

          Toast.makeText(getBaseContext(), tvCountry.getText().toString(), Toast.LENGTH_SHORT).show();
      }
  };

  // Setting the item click listener for the listview
  listView.setOnItemClickListener(itemClickListener);
  
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  // TODO Auto-generated method stub
 
  View row = convertView;
  if(row==null){
   LayoutInflater inflater=getLayoutInflater();
   row=inflater.inflate(R.layout.row, parent, false);
  }
 
  TextView textfilePath = (TextView)row.findViewById(R.id.FilePath);
  textfilePath.setText(videoFileList[position]);
  ImageView imageThumbnail = (ImageView)row.findViewById(R.id.Thumbnail);
 
  Bitmap bmThumbnail;
        bmThumbnail = ThumbnailUtils.createVideoThumbnail(videoFileList[position], Thumbnails.MICRO_KIND);
        imageThumbnail.setImageBitmap(bmThumbnail);
 
  return row;
 }

}

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      str = getIntent().getExtras().getString("name");
      videoFileList[0] = str;
      setListAdapter(new MyThumbnaildapter(listing.this, R.layout.row, videoFileList));
  }
}
