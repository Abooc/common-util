package com.abooc.common.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.abooc.debug.BuildConfig;
import com.abooc.util.Debug;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        boolean enable = Debug.enable();
        Log.d("Debug", "enable:" + enable + ", BuildConfig.DEBUG_ENABLE:" + BuildConfig.DEBUG);




        Debug.anchor();
        Debug.setTag("test");
        Debug.setLevel(Log.VERBOSE);

        Debug.anchor(this);

    }

    public void onReceiveMessage(String message) {
        Debug.anchor(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Debug.destroyClass();
    }
}
