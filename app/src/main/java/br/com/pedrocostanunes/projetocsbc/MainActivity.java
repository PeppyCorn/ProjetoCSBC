package br.com.pedrocostanunes.projetocsbc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextEmail;
    private Button botaoEnviar;

    // ----------------- CHECK BOX ------------------
    private CheckBox checkOp1, checkOp2;
    // ----------------- RADIOBUTTON -----------------
    private RadioButton radioEscolha1, radioEscolha2;
    // ----------------- SPINNER -------------------
    private Spinner spinnerCamiseta;
    // ----------------- SWITCH -------------------
    private Switch switchNotification;
    // ----------------- BUTTON -------------------
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ----------------- CHECK BOX ------------------
        checkOp1 = findViewById(R.id.designMinicurso);
        checkOp2 = findViewById(R.id.wordpressMinicurso);
        // ----------------- RADIOBUTTON -----------------
        radioEscolha1 = findViewById(R.id.radioButtonEstudante);
        radioEscolha2 = findViewById(R.id.radioButtonProfissional);
        // ----------------- SPINNER -------------------
        spinnerCamiseta = findViewById(R.id.spinnerTamanhoCamisa);
        // ----------------- SWITCH -------------------
        switchNotification = findViewById(R.id.switchNotificacoes);
        // ----------------- BUTTON -------------------
        buttonSubmit = findViewById(R.id.botaoEnviar);

        // ----------------- PROGRESS BAR -------------------
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ----------------- SHARED PREFERENCES -------------------
                salvarArquivoSharedPreferences();
                // ----------------- PROGRESS BAR -------------------
                progressBar.setVisibility(View.VISIBLE);
            }

            private void salvarArquivoSharedPreferences() {
                SharedPreferences sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // ----------------- CHECKBOX -------------------
                editor.putBoolean("box1", checkOp1.isChecked());
                editor.putBoolean("box2", checkOp2.isChecked());

                // ----------------- RADIOBUTTON -----------------
                editor.putBoolean("escolha1", radioEscolha1.isChecked());
                editor.putBoolean("escolha2", radioEscolha2.isChecked());

                // ----------------- SPINNER -------------------
                editor.putString("camiseta", spinnerCamiseta.getSelectedItem().toString());
                // ----------------- SWITCH -------------------
                editor.putBoolean("notificacoes", switchNotification.isChecked());

                // ----------------- SALVAR NO SHARED PREFERENCES -------------------
                editor.apply();
                // editor.commit(); é a mesma coisa que o acima
            }
        });

    }
}
