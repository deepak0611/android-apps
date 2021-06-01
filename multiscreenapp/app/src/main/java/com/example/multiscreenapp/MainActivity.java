package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static  final String MSG = "MSG";
    public static String lang = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNow(View view){
        Toast.makeText(this, "sending", Toast.LENGTH_SHORT).show();
    }
    public void receiveNow(View view){
        Toast.makeText(this, "receiving", Toast.LENGTH_SHORT).show();
    }
    public void transmitNow(View view){
        Toast.makeText(this, "transmitting", Toast.LENGTH_SHORT).show();
    }

    public void placeOrder(View view){

        EditText customerName = (EditText) findViewById(R.id.customerName);
        String name = customerName.getText().toString();
        Intent intent = new Intent(this, OrderActivity.class);

        intent.putExtra(MSG,lang);
        startActivity(intent);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.hindi:
                if (checked)
                    lang = "hindi";
                    break;
            case R.id.english:
                if (checked)
                    lang = "english" ;
                    break;

            case R.id.tamil:
                if (checked)
                    lang = "tamil" ;
                break;

            case R.id.marathi:
                if (checked)
                    lang = "marathi" ;
                break;

            case R.id.odiya:
                if (checked)
                    lang = "odiya" ;
                break;

            case R.id.bengali:
                if (checked)
                    lang = "bengali" ;
                break;

        }


    }

}