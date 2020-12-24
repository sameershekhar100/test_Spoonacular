package com.example.food;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity implements itemClicked{


    RecyclerView r;
    String TAG="abcd";
    String s3="",m1="";
    String s4="&apiKey=7e188584acc04ccd85b89df7d1bdb648";

    String url;
    ArrayList<food> items=new ArrayList<>();
    adaptar madapter = new adaptar(this);
    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        r = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        r.setLayoutManager(layoutManager);


         url =getIntent().getStringExtra("link")+ s4 ;




fun();

        r.setAdapter(madapter);
        Log.i(TAG, "ayushman randwa hai");

    }
        private void fun() {


            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    response -> {
                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject jsonObject = response.getJSONObject(i);

                                String title = jsonObject.getString("title");

                                String image = jsonObject.getString("image");
                                JSONArray jsonArray = jsonObject.getJSONArray("missedIngredients");
                                for(int j=0;j<jsonArray.length();j++){
                                    int x=1;
                                    JSONObject missed_ind= jsonArray.getJSONObject(j);
                                    m1= m1 + "\n" + x +":"+missed_ind.getString("name");
                                    x++;
                                }



                                items.add(new food(title,image,m1));
                                m1="";


                            }
                            madapter.updatefood(items);


                        }catch (JSONException e){
                             e.printStackTrace();
                        }
                    }, error -> {

                    });
            singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);



        }


        @Override
    public void onitemClicked(String item) {
    }
}