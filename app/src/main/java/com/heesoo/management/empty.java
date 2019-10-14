package com.heesoo.management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class empty extends AppCompatActivity {

    EditText edtNum1,edtNum2;
    Button[] buttonNum=new Button[10];
    Button btnAdd,btnMul,btnMinus,btnDiv,btnClear,btngobhagi;
    TextView txtResult;
    Integer[] btnID={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
            R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    String num1,num2;
    Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        setTitle("계산기");

        txtResult=(TextView)findViewById(R.id.txtV);
        edtNum1=(EditText)findViewById(R.id.edt1);
        edtNum2=(EditText)findViewById(R.id.edt2);
        btnAdd=(Button)findViewById(R.id.btnplus);
        btnMinus=(Button)findViewById(R.id.btnminus);
        btnDiv=(Button)findViewById(R.id.btndivide);
        btngobhagi=(Button)findViewById(R.id.btngobhagi);
        btnClear=(Button)findViewById(R.id.btnclear);

        //숫자버튼 초기화 (연속처리하기)
        for(int i=0;i<buttonNum.length;i++){
            buttonNum[i]=(Button)findViewById(btnID[i]);
        }

        for(int i=0;i<buttonNum.length;i++){
            final int index=i;
            buttonNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtNum1.isFocused()){
                        num1=edtNum1.getText().toString()+buttonNum[index].getText().toString();    //에러남 ..(지역변수라.. 지역변수는 사용하고 끝나면 없어짐... 그래서 final함수를 사용한거야!!)
                        edtNum1.setText(num1);
                    }else if(edtNum2.isFocused()){
                        num2=edtNum2.getText().toString()+buttonNum[index].getText().toString();
                        edtNum2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),"숫자를 입력하세여",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=edtNum1.getText().toString();
                num2=edtNum2.getText().toString();
                result=Integer.parseInt(num1)+Integer.parseInt(num2);
                txtResult.setText("계산 결과 : "+result.toString());


            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=edtNum1.getText().toString();
                num2=edtNum2.getText().toString();
                result=Integer.parseInt(num1)-Integer.parseInt(num2);
                txtResult.setText("계산 결과 : "+result.toString());
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=edtNum1.getText().toString();
                num2=edtNum2.getText().toString();
                result=Integer.parseInt(num1)/Integer.parseInt(num2);
                txtResult.setText("계산 결과 : "+result.toString());
            }
        });

        btngobhagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=edtNum1.getText().toString();
                num2=edtNum2.getText().toString();
                result=Integer.parseInt(num1)*Integer.parseInt(num2);
                txtResult.setText("계산 결과 : "+result.toString());
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNum1.setText("");
                edtNum2.setText("");
                txtResult.setText("계산 결과 : ");
            }
        });
    }
}