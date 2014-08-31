package com.rakeshdas.smsblocker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

class SmsFilter extends BroadcastReceiver {
    private final String TAG = "SMS";


    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent != null){
            String action = intent.getAction();
            if (action.equals("android.provider.Telephony.SMS_RECEIVED")){
               Bundle extras = intent.getExtras();
                if (extras != null){
                    final AudioManager am = (AudioManager)context.getSystemService(context.AUDIO_SERVICE);
                    am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    //TODO block SMS App
                }
            }
        }


    }

}
        /*if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle extras = intent.getExtras();
            if (extras != null){
                Object[] pdus = (Object[])extras.get("pdus");
                if (pdus.length<1)return; //invalid SMS
                StringBuilder sb = new StringBuilder();
                String sender = null;
                for (int i = 0; i< pdus.length; i++){
                    SmsMessage message = SmsMessage.createFromPdu((byte[])pdus[i]);
                    if (sender == null) sender = message.getOriginatingAddress();
                    String text = message.getMessageBody();
                    if (text != null) sb.append(text);
                }
                if (sender != null){
                    abortBroadcast();
                }
                return;
            }
        }*/
