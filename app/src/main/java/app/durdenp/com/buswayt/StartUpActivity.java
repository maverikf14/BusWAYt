package app.durdenp.com.buswayt;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StartUpActivity extends ActionBarActivity {

    String tag = "StartUpActivity";
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(tag, "Chiamo onCreate");
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();
        intent = new Intent(this, ChooseModeActivity.class);
        final Runnable doNextActivity = new Runnable() {
            @Override
            public void run() {
                // Intent to jump to the next activity

                startActivity(intent);
                finish(); // so the splash activity goes away
            }
        };

        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                handler.post(doNextActivity);
            }
        }.start();


    }






    @Override
    protected void onStart(){
        Log.i(tag, "Chiamo onStart");
        super.onStart();


    }

//    protected void onResume()
//
//    {
//        Log.i(tag, "Chiamo onResume");
//        super.onResume();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Intent intent = new Intent(this, ChooseModeActivity.class);
//            startActivity(intent);
//
//    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
