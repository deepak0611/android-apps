package com.example.volleydemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recycle_view);

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("TAG",response.toString());

                try {

                    for(int i = 0; i < response.length(); i++){
                        JSONObject jresponse = response.getJSONObject(i);
                        String id = jresponse.getString("id");
                        String title = jresponse.getString("title");
                        String body = jresponse.getString("body");
                        Log.d("haff",title);

                        MainData mainData = new MainData();
                        mainData.setId(id);
                        mainData.setTitle(title);
                        mainData.setBody(body);

                        dataList.add(mainData);
                        adapter.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Something went wrong");

            }
        });

        requestQueue.add(jsonArrayRequest);



        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this,dataList);
        recyclerView.setAdapter(adapter);


    }
}