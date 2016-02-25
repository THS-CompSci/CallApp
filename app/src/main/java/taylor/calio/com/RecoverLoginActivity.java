package taylor.calio.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import taylor.calio.com.R;

public class RecoverLoginActivity extends AppCompatActivity {

    private EditText mEmailView;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_login);

        mEmailView = (EditText) findViewById(R.id.email);

        Button mRecoveryButton = (Button) findViewById(R.id.Recover_login);
        mRecoveryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmailView.getText().toString();
                if (email.contains("@") && email.length() > 1){
                    sendEmail();
                }
                else{
                    mEmailView.setText("");
                    Toast.makeText(RecoverLoginActivity.this,
                            "TYPE A REAL EMAIL U DUM DUM", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {email};

        //put sender email here "bot mail account"
        String[] CC = {"xyz@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Calender Recovery Login");
        //put recovery info here
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(RecoverLoginActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}