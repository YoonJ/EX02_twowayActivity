package com.example.yoon.ex02_twowayactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edText1, edText2;
    RadioButton rdAdd, rdSub, rdMul, rdDev;
    RadioGroup group;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText1 = (EditText) findViewById(R.id.edit_num1);
        edText2 = (EditText) findViewById(R.id.edit_num2);
        rdAdd = (RadioButton) findViewById(R.id.radio_add);
        rdSub = (RadioButton) findViewById(R.id.radio_sub);
        rdMul = (RadioButton) findViewById(R.id.radio_mul);
        rdDev = (RadioButton) findViewById(R.id.radio_dev);
        button = (Button) findViewById(R.id.button);
        group = (RadioGroup) findViewById(R.id.radioGroup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

                switch(group.getCheckedRadioButtonId()){
                    case R.id.radio_add:
                        intent.putExtra("calculate", 1);
                        break;
                    case R.id.radio_sub:
                        intent.putExtra("calculate", 2);
                        break;
                    case R.id.radio_mul:
                        intent.putExtra("calculate", 3);
                        break;
                    case R.id.radio_dev:
                        intent.putExtra("calculate",4);
                        break;
                    default:
                        intent.putExtra("calculate", 0);
                }

                intent.putExtra("num1", Integer.parseInt(edText1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edText2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            int result = data.getIntExtra("Result",0);
            Toast.makeText(getApplicationContext(),"결과: "+result, Toast.LENGTH_SHORT).show();
        }
    }
}
