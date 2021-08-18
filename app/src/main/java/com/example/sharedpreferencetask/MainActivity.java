package com.example.sharedpreferencetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText inputEdt;
    TextView outputTv;
    Button save,display;
    SharedPreferences mPreferences;
    private static final String KEY="myData";
    String data = "";
    String SharedPrefsFile = "com.example.android.sharedpreferencetask";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreferences = getSharedPreferences(SharedPrefsFile,MODE_PRIVATE);

        data=mPreferences.getString(KEY,"");


        inputEdt=(EditText)findViewById(R.id.edt);
        outputTv=(TextView)findViewById(R.id.tv);
        save=(Button)findViewById(R.id.save);
        display=(Button)findViewById(R.id.display);
        save.setOnClickListener(this);
        display.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.save:
                data=inputEdt.getText().toString();
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString(KEY,data);
                preferencesEditor.apply();
                Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();
                break;
            case R.id.display:
                outputTv.setText(data);
                break;
        }
    }
}