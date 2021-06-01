package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tomergoldst.tooltips.ToolTipsManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "";
    private static String lang="." ;

    //tooltips
    ToolTipsManager toolTipsManager;
    Button hellobtn;
    RelativeLayout rr;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        ArrayList<language> lang = new ArrayList<>();
        lang.add(new language("English","English"));
        lang.add(new language("हिन्दी","Hindi"));
        lang.add(new language("मराठी","Marathi"));
        lang.add(new language("ગુજરાતી","Gujarati"));
        lang.add(new language("ಕನ್ನಡ","Kannada"));
        lang.add(new language("বাংলা","Bengali"));

        CustomGridAdapter adapter = new CustomGridAdapter(this,R.layout.grid_view_layout,lang);
        gridView.setAdapter(adapter);


        //tooltip
        toolTipsManager = new ToolTipsManager(this);
        hellobtn = findViewById(R.id.hellobtn);

        hellobtn.setOnClickListener(this);
        rr = findViewById(R.id.haha);






    }

    public void selectLanguage(View view){
        boolean checked = ((RadioButton) view).isChecked();

//        Toast.makeText(this, , Toast.LENGTH_SHORT).show();

        View root = view.getRootView();
//        root.get
        
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    Toast.makeText(this,"hello1" , Toast.LENGTH_SHORT).show();//lang = "hindi";

                    break;
            default:
                Toast.makeText(this, "hello2", Toast.LENGTH_SHORT).show();//lang = "english";
                break;
        }


    }

    public void showLanguage(View view){
        if(lang==".") {
            Toast.makeText(this, "Please select a language", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, languageActivity.class);

            intent.putExtra(MSG, lang);
            startActivity(intent);
        }
    }




}

