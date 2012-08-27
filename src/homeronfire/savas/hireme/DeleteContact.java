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

public class DeleteContact extends Activity implements OnClickListener {

	private EditText idReceived;
	private Button delete;
	private Button cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.delete_contact);

		idReceived = (EditText) findViewById(R.id.etIdReceived);
		delete = (Button) findViewById(R.id.bDelete);
		cancel = (Button) findViewById(R.id.bCancelDelete);

		delete.setOnClickListener(this);
		cancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bDelete:
			try {
				String strRow = idReceived.getText().toString();
				long intRow = Long.parseLong(strRow);
				SQLiteHandler sqlHandler = new SQLiteHandler(this);
				sqlHandler.open();
				sqlHandler.deleteEntry(intRow);				
				sqlHandler.close();
			} catch (Exception ex) {
				String error = ex.toString();
				Dialog dialog = new Dialog(this);
				dialog.setTitle("Failed");
				TextView tView = new TextView(this);
				tView.setText(error);
				dialog.setContentView(tView);
				dialog.show();
			}
			break;
		case R.id.bCancelDelete:
			finish();
			break;
		}

	}

}
