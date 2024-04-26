package com.example.aula13;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final EditText edt1 = (EditText) findViewById(R.id.editTextText1);
        final EditText edt2 = (EditText) findViewById(R.id.editTextText2);
        final Button botao = (Button) findViewById(R.id.button1);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView texto = (TextView) findViewById(R.id.textView2);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double v1, v2, total;
                    v1 = Double.parseDouble(edt1.getText().toString());
                    v2 = Double.parseDouble(edt2.getText().toString());
                    switch (spinner.getSelectedItemPosition()) {
                        case 0:
                            total = v1 + v2;
                            texto.setText("" + total);
                            break;
                        case 1:
                            total = v1 - v2;
                            texto.setText("" + total);
                            break;
                        case 2:
                            total = v1 * v2;
                            texto.setText("" + total);
                            break;
                        case 3:
                            total = v1 / v2;
                            texto.setText("" + total);
                            break;
                        case 4:
                            total = Math.pow(v1, v2);
                            texto.setText("" + total);
                            break;
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Valores inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}