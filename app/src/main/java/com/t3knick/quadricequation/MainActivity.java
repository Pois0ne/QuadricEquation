package com.t3knick.quadricequation;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.t3knick.quadricequation.MathLogic.QuadEq;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText editText_a;
    EditText editText_b;
    EditText editText_c;

    TextView textView_Root_X1;
    TextView textView_Root_X2;

    TextView textView_dis;

    Button button_solve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_a = findViewById(R.id.editText_a);
        editText_b = findViewById(R.id.editText_b);
        editText_c = findViewById(R.id.editText_c);
        textView_Root_X1 = findViewById(R.id.textView_Root_X1);
        textView_Root_X2 = findViewById(R.id.textView_Root_X2);
        button_solve = findViewById(R.id.button_solve);
        textView_dis = findViewById(R.id.textView_dis);

        button_solve.setOnClickListener(view -> onSolveButtonPressed());
    }

    @SuppressLint("ResourceAsColor")
    void onSolveButtonPressed(){
        double a;
        double b;
        double c;

        try {

            a = Double.parseDouble(editText_a.getText().toString());
            b = Double.parseDouble(editText_b.getText().toString());
            c = Double.parseDouble(editText_c.getText().toString());

        } catch (Exception e) {

            if (Objects.equals(e.getMessage(), "empty String")){
                Toast.makeText(MainActivity.this, R.string.empty_fields, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
            return;
        }


        QuadEq q = new QuadEq(a, b, c);


        if (q.getDis() > 0){
            textView_Root_X1.setText(String.format("X1 = %s",q.getX1()));
            textView_Root_X2.setText(String.format("X2 = %s",q.getX2()));
            textView_dis.setText(String.format("D = %s",q.getDis()));
            textView_Root_X2.setVisibility(View.VISIBLE);
        }else if (q.getDis() == 0){
            textView_Root_X1.setText(String.format("X1 = %s",q.getX1()));
            textView_Root_X2.setVisibility(View.GONE);
            textView_dis.setText(String.format("D = %s",q.getDis()));
        }else {
            textView_Root_X1.setText(R.string.no_roots);
            textView_Root_X2.setVisibility(View.GONE);
            textView_dis.setText(String.format("D = %s",q.getDis()));
        }
    }
}

