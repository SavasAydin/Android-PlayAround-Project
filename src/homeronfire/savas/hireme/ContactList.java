package homeronfire.savas.hireme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContactList extends Activity implements OnClickListener{

	private Button addButton;
	private Button deleteButton;
	private Button showButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);		
		
		setContentView(R.layout.contact_list);
		
		addButton = (Button)findViewById(R.id.bAddContact);
		deleteButton = (Button)findViewById(R.id.bDeleteContact);
		showButton = (Button)findViewById(R.id.bShowContacts);
		
		addButton.setOnClickListener(this);
		deleteButton.setOnClickListener(this);
		showButton.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bAddContact:
			Intent addIntent = new Intent("homeronfire.savas.hireMe.ADDED");
			startActivity(addIntent);
			break;
		case R.id.bDeleteContact:
			Intent deleteIntent = new Intent("homeronfire.savas.hireMe.DELETECONTACTS");
			startActivity(deleteIntent);
			break;
		case R.id.bShowContacts:
			Intent showIntent = new Intent("homeronfire.savas.hireMe.SHOWCONTACTS");
			startActivity(showIntent);			
			break;
		}		
	}
	
	
	
	

}
