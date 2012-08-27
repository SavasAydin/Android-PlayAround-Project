package homeronfire.savas.hireme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ShowContacts extends Activity {

	private TextView tvId;
	private TextView tvName;
	private TextView tvEmail;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.show_contacts);
		
		tvId = (TextView)findViewById(R.id.tvGotID);
		tvName = (TextView)findViewById(R.id.tvGotName);
		tvEmail = (TextView)findViewById(R.id.tvGotEmail);
		
		SQLiteHandler showData = new SQLiteHandler(this);
		showData.open();
		String dataId = showData.getID();
		String dataName = showData.getName();
		String dataEmail = showData.getEmail();
		tvId.setText(dataId);
		tvName.setText(dataName);
		tvEmail.setText(dataEmail);
	} 
	

}
