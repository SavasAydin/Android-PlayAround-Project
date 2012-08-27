package homeronfire.savas.hireme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements OnClickListener {

	private EditText name, phoneNumber, messageBody;
	private Button sendEmail, cancelMail;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.email);
		initializeVar();
	}

	public void initializeVar() {
		name = (EditText) findViewById(R.id.etName);
		phoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
		messageBody = (EditText) findViewById(R.id.etMailMessage);
		sendEmail = (Button) findViewById(R.id.bSendEmail);
		cancelMail = (Button)findViewById(R.id.bCancelMail);

		sendEmail.setOnClickListener(this);
		cancelMail.setOnClickListener(this);		

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSendEmail:
			String userName = name.getText().toString();
			String mobile = phoneNumber.getText().toString();
			String emailAddress[] = { "savasaydin@gmail.com" };
			String message = "Hello, I am " + userName + "\n"
					+ messageBody.getText().toString() + "\n Phone me: "
					+ mobile;

			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
					emailAddress);
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Job Opportunity");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
			emailIntent.setType("/plain/text");
			startActivity(emailIntent);
			break;
		case R.id.bCancelMail:
			finish();
			break;
		}

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
