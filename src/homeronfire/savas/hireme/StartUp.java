package homeronfire.savas.hireme;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;

public class StartUp extends Activity {

	MediaPlayer favoriteSong;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        setContentView(R.layout.startup);
        
        favoriteSong = MediaPlayer.create(StartUp.this, R.raw.splashsound);
        favoriteSong.start();
        
        Thread timer = new Thread(){
        	public void run(){
        		try{        	
        		sleep(1000);        		
        		}catch(InterruptedException ex){
        		ex.printStackTrace();
        		}finally{
        		Intent intent = new Intent("homeronfire.savas.hireMe.MENU");
        		startActivity(intent);
        		}
        	}
        };
        timer.start();
    }
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		favoriteSong.release();
		finish();
	}
    
    

    
}
