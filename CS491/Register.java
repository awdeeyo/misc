package com.intrinsic.cid.intrinsic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Register extends AppCompatActivity implements View.OnClickListener {


    public static final String URL_SAVE_NAME = "https://web.njit.edu/~kl297/web/saveName.php";
    String URL= "https://web.njit.edu/~kl297/web/verifyregistration.php";

    JSONParser jsonParser=new JSONParser();
    int j = 0;

    //database helper object
    private DatabaseHelper db;

    //View objects
    private Button buttonSave;
    private EditText TextName;
    private EditText TextEmail;
    private EditText TextPass;
    private EditText TextVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        registerReceiver(new NetworkStateChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        //initializing views and objects
        db = new DatabaseHelper(this);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        TextName = (EditText) findViewById(R.id.TextName);
        TextEmail = (EditText) findViewById(R.id.TextEmail);
        TextPass = (EditText) findViewById(R.id.TextPass);
        TextVerify = (EditText) findViewById(R.id.TextVerify);

        //adding click listener to button
        buttonSave.setOnClickListener(this);

    }

    private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }
        @Override

        protected JSONObject doInBackground(String... args) {

            String phone = args[0];
            String email = args[1];
            String pass = args[2];
            ArrayList param = new ArrayList();
            param.add(new BasicNameValuePair("phone", phone));
            param.add(new BasicNameValuePair("email", email));
            param.add(new BasicNameValuePair("pass", pass));

            JSONObject getjson = jsonParser.makeHttpRequest(URL, "POST", param);


            return getjson;

        }

        protected void onPostExecute(JSONObject result) {
            //check to see if phone/email exists in database
            try {
                String outjson = result.getString("message");
                if(outjson.contains("true") && j == 0){
                    TextView title = (TextView) findViewById(R.id.textView);
                    title.setTextColor(Color.RED);
                    title.setTypeface(null, Typeface.ITALIC);
                    title.setText(String.valueOf("username/email already in use"));
                } else if(j == 0){
                    //check to see if registration went through successfully
                    j++;
                    URL = "https://web.njit.edu/~kl297/web/saveName.php";
                    Register.AttemptLogin register = new Register.AttemptLogin();
                    register.execute(TextName.getText().toString(),TextEmail.getText().toString(),TextPass.getText().toString());
                    try {
                        String getjson = result.getString("error");
                        if(getjson.contains("false")){
                            Toast.makeText(getApplicationContext(), "Registration Successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                        } else{
                            Toast.makeText(getApplicationContext(), "Registration unsuccessful, please try again.", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void onClick(View view) {

        if(TextEmail.getText().toString().equals("") ||
                TextPass.getText().toString().equals("")  ||
                TextName.getText().toString().equals("")){

            TextView title = (TextView) findViewById(R.id.textView);
            title.setTextColor(Color.RED);
            title.setTypeface(null, Typeface.ITALIC);
            title.setText(String.valueOf("fields are empty"));
        }else if(!TextEmail.getText().toString().equals(TextVerify.getText().toString())){
            TextView title = (TextView) findViewById(R.id.textView);
            title.setTextColor(Color.RED);
            title.setTypeface(null, Typeface.ITALIC);
            title.setText(String.valueOf("emails don't match"));
        } else if(TextName.getText().toString().trim().replaceAll("[\\s\\-()]", "").length() != 10){
            TextView title = (TextView) findViewById(R.id.textView);
            title.setTextColor(Color.RED);
            title.setTypeface(null, Typeface.ITALIC);
            title.setText(String.valueOf("invalid phone number length"));
        }else{
            Register.AttemptLogin attemptLogin= new Register.AttemptLogin();
            attemptLogin.execute(TextName.getText().toString(),TextEmail.getText().toString(),"");
        }

    }

}
