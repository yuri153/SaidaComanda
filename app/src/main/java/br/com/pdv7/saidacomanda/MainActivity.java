package br.com.pdv7.saidacomanda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.pdv7.saidacomanda.Business.ComandaBusiness;

public class MainActivity extends AppCompatActivity {

    private Button buttonConfirmar;
    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConfirmar = findViewById(R.id.buttonConsultar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }

    public void Consulta (final View view){

        ComandaBusiness comandaBusiness = new ComandaBusiness(this);
        comandaBusiness.ConsultaComanda(editText);


    }
}

