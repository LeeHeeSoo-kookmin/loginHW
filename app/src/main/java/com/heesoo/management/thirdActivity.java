package com.heesoo.management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class thirdActivity extends AppCompatActivity {
    EditText num1, num2;
    Button btnadd, btnsub, btnmul, btndiv,btnres;
    TextView result;
    int res;
    Button[] numbuttons = new Button[10];

    Integer[] numbuttonID = {R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9,
            R.id.button0 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EditText idText = (EditText) findViewById(R.id.idText);
        EditText nameText = (EditText) findViewById(R.id.nameText);

        num1 = (EditText) findViewById(R.id.Edit1);
        num2 = (EditText) findViewById(R.id.Edit2);

        btnadd = (Button) findViewById(R.id.buttonAdd);
        btnsub = (Button) findViewById(R.id.buttonSub);
        btnmul = (Button) findViewById(R.id.buttonMul);
        btndiv = (Button) findViewById(R.id.buttonDiv);
        btnres = (Button) findViewById(R.id.buttonRes);

        result = (TextView) findViewById(R.id.TextResult);

        for (int i=0; i<numbuttonID.length; i++) {
            final int index;
            index = i;

            numbuttons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String a,b;

                    if(num1.isFocused()==true) {
                        a=num1.getText().toString() + numbuttons[index].getText().toString();
                        num1.setText(a);
                    }
                    else if(num2.isFocused() == true) {
                        b=num2.getText().toString() + numbuttons[index].getText().toString();
                        num2.setText(b);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"숫자가 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        View.OnClickListener clisten = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b;
                a=Integer.parseInt(num1.getText().toString());
                b=Integer.parseInt(num2.getText().toString());

                switch (v.getId()) {
                    case R.id.buttonAdd:
                    res = a+b;
                    break;
                    case R.id.buttonSub:
                        res = a-b;
                    case R.id.buttonMul:
                        res = a*b;
                        break;
                    case R.id.buttonDiv:
                        res = a/b;
                        break;
                }
            }
        };
        btnadd.setOnClickListener(clisten);
        btnsub.setOnClickListener(clisten);
        btnmul.setOnClickListener(clisten);
        btndiv.setOnClickListener(clisten);
        btnres.setOnClickListener(clisten);

    }
}
