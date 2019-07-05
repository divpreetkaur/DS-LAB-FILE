package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
  EditText editText;
  EditText editText1;
 // EditText editText2;
  Button button;
  //final SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.et_main1);
        editText1=findViewById(R.id.et_main2);
        button=findViewById(R.id.btn_main);
        final SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
         loaddata();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = editText.getText().toString();
                String ph  = editText1.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Name", n);
                editor.putString("Phone", ph);
                editor.apply();
//               sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//                String n1=sharedPreferences.getString("name","hello");
//                editText.setText(n1);
            }
        });


        }
        public void loaddata()
        {
            SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            String n1=sharedpreferences.getString("Name","null");
            editText.setText(n1);
        }

}
