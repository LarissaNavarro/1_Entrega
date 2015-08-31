package br.usjt.cervejap1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.TreeSet;

public class ListaCervejaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cerveja);

        Especialista especialista = new Especialista();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String cor = intent.getStringExtra(MainActivity.COR);
        String pais = intent.getStringExtra(MainActivity.PAIS);
        String estilo = intent.getStringExtra(MainActivity.ESTILO);

        TreeSet<Cerveja> lista = especialista.listarMarcas(estilo, cor, pais);

        //cria o texto da view
        TextView textView = (TextView) findViewById(R.id.txt_lista_cerveja);
        String message = "";
        for(Cerveja cerveja:lista){
            message += cerveja.getNome() + "\n";
        }
        if(message.length() == 0) {
            message = "Nenhuma cerveja encontrada para o critério escolhido.";
            textView.setLines(3);
        } else {
            textView.setLines(lista.size());
        }
        textView.setText(message);
    }

}
