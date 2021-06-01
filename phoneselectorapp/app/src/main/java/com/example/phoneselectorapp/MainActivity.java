package com.example.phoneselectorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;

public class MainActivity extends AppCompatActivity {

    private static final int CREDENTIAL_PICKER_REQUEST = 120;

    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.text);
        bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneSeleection();
            }
        });

    }

    public void phoneSeleection(){
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent intent = Credentials.getClient(MainActivity.this).getHintPickerIntent(hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(),
                    CREDENTIAL_PICKER_REQUEST, null, 0, 0, 0,new Bundle());
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREDENTIAL_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                // credential.getId(); <-- E.164 format phone number on 10.2.+ devices
                tv.setText(credential.getId());
            }
            else if(resultCode == CredentialsApi.ACTIVITY_RESULT_NO_HINTS_AVAILABLE){
                Toast.makeText(this, "No phone number found", Toast.LENGTH_SHORT).show();
            }
        }
    }



}