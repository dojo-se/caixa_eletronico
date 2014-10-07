package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.caixaeletronico.MainActivity;
import com.example.caixaeletronico.R;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity>{

	MainActivity activity;
	TextView texto;
	EditText input;
	Button botao;
	
	public MainActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
		 
	}
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		startActivity(new Intent(getInstrumentation().getTargetContext(),MainActivity.class),null, null);

		activity = (MainActivity)getActivity();
		texto = (TextView)activity.findViewById(R.id.texto);
		 input = (EditText) activity.findViewById(R.id.editText1);
	     botao = (Button) activity.findViewById(R.id.botao);
	}
	
	public void testeSimples(){		
		//botao.performClick();
		//assertTrue(true);
		assertEquals("Hello world!", texto.getText());
	}
	
	public void testLer100(){
		input.setText("100");
		botao.performClick();
		assertEquals("1", texto.getText());
	}
	
	public void testLer150(){
		input.setText("150");
		botao.performClick();
		assertEquals("2", texto.getText());
	}

	public void testLer170(){
		input.setText("170");
		botao.performClick();
		assertEquals("3", texto.getText());
	}

	public void testLer275(){
		input.setText("275");
		botao.performClick();
		assertEquals("Quantidade inválida!", texto.getText());
	}
	
	public void testEntradaTexto() {
		input.setText("Windows 9");
		botao.performClick();
		assertEquals("Deve ser número inteiro", texto.getText());
	}
	
	public void testEntradaNegativa() {
		input.setText("-1");
		botao.performClick();
		assertEquals("Deve ser número maior que zero", texto.getText());
	}

}
