package bte.ebresztoora;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // ébresztőóra kezelő elkészítése

    AlarmManager alarm_manager;
    TimePicker alarm_timePicker;
    TextView update_text;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.context = this;

        // ébresztőkezelő előkészítése

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //timepicker előkészítése

        alarm_timePicker = (TimePicker) findViewById(R.id.timePicker);

        // text update box előkészítése (ez fogja megmondani h bevan kapcsolva az ébresztő vagy sem

        update_text = (TextView) findViewById(R.id.updateText);


        Calendar calendar = Calendar.getInstance();

        // bekapcs gomb előkészítése
        Button alarmOn= (Button) findViewById(R.id.alarmOn);

        // onclick listener a bekapcsoláshoz

        //kikapcs gomb előkészítése
        Button alarmOff= (Button) findViewById(R.id.alarmOff);

        //onclick listener a kikapcsoláshoz/visszavonáshoz
        alarmOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //megváltoztatja a középső textbox feliratját

                set_alarm_text("Ébresztő ON!");

            }
        });


    }

    private void set_alarm_text(String output) {
        update_text.setText(output);
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
