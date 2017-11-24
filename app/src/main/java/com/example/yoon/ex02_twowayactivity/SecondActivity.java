package com.example.yoon.ex02_twowayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Yoon on 2017-11-23.
 */

public class SecondActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        int result;

        Intent inIntent = getIntent();
        switch(inIntent.getIntExtra("calculate", 0)){
            case 1:
                result = inIntent.getIntExtra("num1",0) + inIntent.getIntExtra("num2",0);
                break;
            case 2:
                result = inIntent.getIntExtra("num1",0) - inIntent.getIntExtra("num2",0);
                break;
            case 3:
                result = inIntent.getIntExtra("num1",0) * inIntent.getIntExtra("num2",0);
                break;
            case 4:
                result = inIntent.getIntExtra("num1",0) / inIntent.getIntExtra("num2",0);
                break;
            default:
                result =0;
                break;
        }

        Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
        outIntent.putExtra("Result", result);
        setResult(RESULT_OK, outIntent);
        finish();
    }
}
