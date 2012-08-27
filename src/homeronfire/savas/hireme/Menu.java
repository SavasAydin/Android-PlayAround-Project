package homeronfire.savas.hireme;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Menu extends ListActivity {

	private String functions[] = {"Email Me", "Contact List","function3"}; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, 
				android.R.layout.simple_list_item_1, functions));		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch(position){
			case 0:
				Intent intentEmail = new Intent("homeronfire.savas.hireMe.EMAIL");
				startActivity(intentEmail);
				break;
			case 1:
				Intent intentContact = new Intent("homeronfire.savas.hireMe.CONTACT");
				startActivity(intentContact);
				break;
			case 2:
				
				break;
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {	
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.my_menu, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.aboutMe:
			Intent intentAbout = new Intent("homeronfire.savas.hireMe.ABOUTME");
			startActivity(intentAbout);
			break;		
		case R.id.exit:
			finish();
		break;
		}
		return false;
	}
	
	
	
	

}
