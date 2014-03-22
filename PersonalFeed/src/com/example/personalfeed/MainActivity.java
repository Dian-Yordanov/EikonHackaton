package com.example.personalfeed;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
	public static ListView personalityListView;
	
	 String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
		        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
		        "Android", "iPhone", "WindowsMobile" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		personalityListView = (ListView) findViewById(R.id.personalityListView);
		
		 

			    final ArrayList<String> list = new ArrayList<String>();
			    for (int i = 0; i < values.length; ++i) {
			      list.add(values[i]);
			    }
			    final StableArrayAdapter adapter = new StableArrayAdapter(this,
			        android.R.layout.simple_list_item_1, list);
			    personalityListView.setAdapter(adapter);
//
//			    personalityListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//			    @Override
//			    public void onItemClick(AdapterView<?> parent, final View view,
//			        int position, long id) {
//			      final String item = (String) parent.getItemAtPosition(position);
//			      view.animate().setDuration(2000).alpha(0)
//			          .withEndAction(new Runnable() {
//			            @Override
//			            public void run() {
//			              list.remove(item);
//			              adapter.notifyDataSetChanged();
//			              view.setAlpha(1);
//			            }
//			          });
//			    }
//
//			
//			  });

			      
			    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
