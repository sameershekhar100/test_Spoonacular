package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG ="xyz" ;
    private Button b1,b2;
     public String s2, s1="";

    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.add);
        b2=findViewById(R.id.button);
        e1=findViewById(R.id.ingredients);
        ArrayList<String> ind=new ArrayList<>();
        b1.setOnClickListener(v -> {
            s2 = e1.getText().toString();
            ind.add(s2);
            e1.setText("");

            for(int i=0 ; i<ind.size()-1 ; i++){
                s1=s1+ ind.get(i)+",+";
            }
            s1=s1+ind.get(ind.size()-1);


        });


        b2.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this,FoodActivity.class);


            i.putExtra("link", "https://api.spoonacular.com/recipes/findByIngredients?ingredients="+s1);
           startActivity(i);


        });


    }

}