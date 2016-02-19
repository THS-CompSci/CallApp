package taylor.calio.com;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Cursor c;
    private SQLiteOpenHelper db;
    private SQLiteDatabase data;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);


    }
    public void signIn(View v){
        attemptLogin();
    }
    public void attemptLogin(){
        db = new Database(this);
        data = db.getReadableDatabase();

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        if(this.isEmailValid(email)&&this.isPasswordValid(password)) {
            c = data.query("users",new String[]{"_id"},"email = ? and password = ?",new String[]{email,password},null,null,null,null);

            if(c.getCount()==1){
                Intent intent = new Intent(this, CalendarActivity.class);
                //intent.putExtra("username",c.getString(0));
                startActivity(intent);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "You got it wrong", 4000);
                toast.show();
            }

        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a valid email and password", 4000);
            toast.show();
        }

    }
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public void onDestroy(){
        c.close();
        data.close();
    }
}
