package com.sidhantpanda.loadingviewswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.sidhantpanda.loadingviewswitcher.views.LoadingViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private LoadingViewSwitcher loadingViewSwitcher;

    private int STATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingViewSwitcher = (LoadingViewSwitcher) findViewById(R.id.testSwitcher);

        final Button toggle = (Button) findViewById(R.id.btn_toggle);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle(STATE);
                if (STATE == 2) {
                    STATE = 0;
                } else {
                    STATE++;
                }
            }
        });
    }

    private void toggle(int state) {
        switch (state) {
            case 0:
                loadingViewSwitcher.showLoading();
                break;

            case 1:
                loadingViewSwitcher.showContent();
                break;

            case 2:
                loadingViewSwitcher.showError();
                break;
        }
    }

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
