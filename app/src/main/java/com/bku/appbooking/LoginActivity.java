package com.bku.appbooking;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txEmail, txPassword;
    Button btLogin;
//    MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpView();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin(txEmail.getText().toString(), txPassword.getText().toString());
            }
        });

    }

    public void onLogin(String email, String pass) {
        if (email.equals("") || pass.equals("")) {
            Toast.makeText(this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO: Gui den sever, tra ve true - false

        String message = true ? "Dang nhap thanh cong" : "Dang nhap that bai, vui long thu lai";

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


        if (true){  //TODO: gui den server- tra ve true-false
//            myAsyncTask = new MyAsyncTask(this);
//            myAsyncTask.execute();
            Intent intent = new Intent(LoginActivity.this, BookingActivity.class);
            startActivity(intent);
        }
    }

    public void onRegister(View v) {
        // Chuyen den Register Activity

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void setUpView(){
        txEmail = (EditText) findViewById(R.id.txEmail);
        txPassword = (EditText) findViewById(R.id.txPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
    }

//    class MyAsyncTask extends AsyncTask<Activity, Integer, Void> {
//
//        Activity contextParent;
//
//
//        public MyAsyncTask(Activity contextParent) {
//            this.contextParent = contextParent;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Void doInBackground(Activity... params) {
//            utils.getJsonFromUrl(contextParent, "");
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            Toast.makeText(contextParent, "Start Booking activity", Toast.LENGTH_SHORT).show();
//
//        }
//    }
}
