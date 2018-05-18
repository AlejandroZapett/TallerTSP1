package me.alejnadrozapett.ejercicio1;

import android.annotation.SuppressLint;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button registroButton;
    EditText numCuenta, nombre, apellidos, correo;
    EditText campo[] = new EditText[4];
    RadioButton hombre, mujer;
    Spinner opciones;
    String gen = "";
    String fac = "";
    String facultades[] = new String[5];
    RegistroAlumno alumno;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numCuenta = (EditText) findViewById(R.id.editTextNumCuenta);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellidos = (EditText) findViewById(R.id.editTextApellidos);
        correo = (EditText) findViewById(R.id.editTextCorreo);
        hombre = (RadioButton) findViewById(R.id.radioButtonHombre);
        mujer = (RadioButton) findViewById(R.id.radioButtonMujer);
        opciones = (Spinner) findViewById(R.id.spinnerFacultad);
        campo[0]=nombre;
        campo[1]=apellidos;
        campo[2]=numCuenta;
        campo[3]=correo;
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
        opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                facultad((String) adapter.getItem(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        registroButton = (Button) findViewById(R.id.Registrar);
        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    private void facultad(String item){
        fac = item;
    }
    public void genero(View view){
        if(mujer.isChecked()){
            gen = mujer.getText().toString();
        }else
            if(hombre.isChecked()){
                gen = hombre.getText().toString();
            }
    }

    private void validar(){
        for(int i=0; i<4; i++){
            campo[i].setError(null);
        }
        for(int i=0; i<4; i++){
            if(TextUtils.isEmpty(campo[i].getText().toString())){
                campo[i].setError(getString(R.string.error_campo_obligatorio));
                campo[i].requestFocus();
                return;
            }
        }
        if (campo[2].getText().toString().length() != 9 ){
            campo[2].setError(getString(R.string.error_num_cuenta));
            campo[2].requestFocus();
            return;
        }
        if (gen == ""){
            hombre.setError(getString(R.string.error_campo_obligatorio));
            mujer.setError(getString(R.string.error_campo_obligatorio));
            return;
        }
        if (fac == ""){
            return;
        }


        Registro();
    }

    private void Registro(){
        alumno = new RegistroAlumno(nombre.getText().toString(),
                apellidos.getText().toString(),
                Long.parseLong(numCuenta.getText().toString()),
                correo.getText().toString(),
                gen,
                fac);
        Toast.makeText(getApplicationContext(),alumno.toString(),Toast.LENGTH_LONG).show();
    }

}
