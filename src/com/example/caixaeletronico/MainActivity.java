package com.example.caixaeletronico;

import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView text;
	EditText input;
	Button botao;
	
	String[] notasDisponiveis = {"100", "50", "20", "10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = (TextView)findViewById(R.id.texto);
        input = (EditText) findViewById(R.id.editText1);
        botao = (Button) findViewById(R.id.botao);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void clickBotao(View view){
    	String notas ="";
    	int qntNotas = 0;
    	String texto = input.getText().toString();
    	
    	int quantia;
		try {
			quantia = Integer.parseInt(texto);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			text.setText("Deve ser número inteiro");
			return;
		}
		
		if (quantia < 0){
			text.setText("Deve ser número maior que zero");
			return;			
		}
    	
    	//notasDisponiveis
    	
    	for(int i=0; i< notasDisponiveis.length; i++){
    		int valor = Integer.parseInt(notasDisponiveis[i]);
    		
    		qntNotas += quantia/valor;
    		quantia = quantia%valor;
    	}
    	
		notas = String.valueOf(qntNotas);
		
		if (quantia > 0) {
    		notas = "Quantidade inválida!";
    	}
		text.setText(notas);
    }
    
}
