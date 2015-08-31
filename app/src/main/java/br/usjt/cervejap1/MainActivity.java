package br.usjt.cervejap1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerEstilo;
    Spinner spinnerCor;
    Spinner spinnerPais;
    Button btnConsultar;
    String pais, cor, estilo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews() {
        estilo = "";
        cor = "";
        pais = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);
        spinnerEstilo = (Spinner) findViewById(R.id.dropdown_estilos);
        spinnerEstilo.setOnItemSelectedListener(new EstiloSelecionado());
        spinnerCor = (Spinner) findViewById(R.id.dropdown_cores);
        spinnerCor.setOnItemSelectedListener(new CorSelecionada());
        spinnerPais = (Spinner) findViewById(R.id.dropdown_paises);
        spinnerPais.setOnItemSelectedListener(new PaisSelecionado());
     }

    private class EstiloSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            estilo = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class CorSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            cor = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class PaisSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            pais = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar a mensagem
    public final static String COR = "br.usjt.COR";
    public final static String PAIS = "br.usjt.PAIS";
    public final static String ESTILO = "br.usjt.ESTILO";
    //será chamado quando o usuário clicar em enviar
    public void consultarCervejas(View view) {

        String pEstilo = this.estilo.equals("Escolha o estilo")?"":estilo;
        String pCor = this.cor.equals("Escolha a cor")?"":cor;
        String pPais = this.pais.equals("Escolha o país")?"":pais;

        Intent intent = new Intent(this, ListaCervejaActivity.class);
        intent.putExtra(COR, pCor);
        intent.putExtra(PAIS, pPais);
        intent.putExtra(ESTILO, pEstilo);
        startActivity(intent);


    }

}
