package homeronfire.savas.hireme;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddContact extends Activity implements OnClickListener {

	private EditText nameToAdded;
	private EditText emailToAdded;
	private Button save;
	private Button cancel;
	
	private String name, email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.add_contact);
		
		

		nameToAdded = (EditText) findViewById(R.id.etNameToAdded);
		emailToAdded = (EditText) findViewById(R.id.etEmailToAdded);
		save = (Button) findViewById(R.id.bSaveContact);
		cancel = (Button) findViewById(R.id.bCancelAdd);

		save.setOnClickListener(this);
		cancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSaveContact:
			boolean isAdded = true;
			try {
				name = nameToAdded.getText().toString();
				email = emailToAdded.getText().toString();

				SQLiteHandler entry = new SQLiteHandler(AddContact.this);
				entry.open();
				entry.persistEntry(name, email);
				entry.close();
			} catch (Exception ex) {
				isAdded = false;
			}finally{
				if(isAdded){
					Dialog dialog = new Dialog(this);
					dialog.setTitle("Entry Succeed");
					TextView tView = new TextView(this);
					tView.setText("Email address of " + name + " is added");
					dialog.setContentView(tView);
					dialog.show();
					
					Thread sleep = new Thread(){
						public void run(){
							try{
								sleep(3000);
							}catch(InterruptedException exception){
								exception.printStackTrace();
							}finally{
								finish();
							}
						}
					};					
					sleep.start();
				}
				
			}
			break;
		case R.id.bCancelAdd:
			finish();
			break;
		}

	}

}
