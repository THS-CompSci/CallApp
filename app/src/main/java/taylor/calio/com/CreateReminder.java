package taylor.calio.com;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import com.codetroopers.betterpickers.*;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

import taylor.calio.com.R;

public class CreateReminder extends AppCompatActivity {

    private TextView titleTV;
    private TextView descriptionTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleTV = (TextView)findViewById(R.id.input_title);
        descriptionTV = (TextView)findViewById(R.id.input_description);


    }


    public void onSetDateTime(View view) {
//        Bundle args = new Bundle();
//        args.putString("title", "Dialog with Action Bar");
//        SetDate actionbarDialog = new SetDate();
//        actionbarDialog.setArguments(args);
//        actionbarDialog.show(getSupportFragmentManager(),
//                "action_bar_frag");

        //
//        actionbarDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//
//            public void onCancel(DialogInterface arg0) {
//                dialog.dismiss();
//            }
//
//        });

//        Intent intent = new Intent(this,SetDate.class);
//        startActivity(intent);

        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getSupportFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment)
                .setYearOptional(true);
        dpb.show();

    }

    public void onCreateReminder(View view) {
        String title = titleTV.getText().toString();
        String description = descriptionTV.getText().toString();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plain, menu);
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
