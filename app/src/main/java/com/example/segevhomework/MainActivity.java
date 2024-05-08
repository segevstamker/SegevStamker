package com.example.segevhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String userChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result=findViewById(R.id.result);
        //result.setText("Hello");
        EditText num1=findViewById(R.id.num1);
        EditText num2=findViewById(R.id.num2);
        Button button=findViewById(R.id.button);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource
                        (this,
                                R.array.Operator_array,
                                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userChoice=(String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    int n1=Integer.parseInt(num1.getText()+"");
                    int n2=Integer.parseInt(num2.getText()+"");
                    int res;
                    switch (userChoice){
                        case "+":
                            res=n1+n2;
                            result.setText(res+"");
                            break;
                        case "-":
                            res=n1-n2;
                            result.setText(res+"");
                            break;
                        case "*":
                            res=n1*n2;
                            result.setText(res+"");
                            break;
                        case "/":
                            if(n2==0)
                            {
                                result.setText("0");
                            }
                            res=n1/n2;
                            result.setText(res+"");
                            break;
                        case "^":
                            res=(int)Math.pow(n1,n2);
                            result.setText(res+"");
                            break;
                    }
                }
                catch (Exception err){
                    result.setText("ERROR");
                }
            }
        });
    }
}