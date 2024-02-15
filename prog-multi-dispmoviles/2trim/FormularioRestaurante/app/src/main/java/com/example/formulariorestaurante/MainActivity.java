package com.example.formulariorestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etAcercaDe, etFecha, etValoracion, etTelefono, etNombre;
    private Spinner etSituacionSpinner;
    private Button btnGuardar, btnMostrarResultados;
    private CuestionarioDAO cuestionarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAcercaDe = findViewById(R.id.etAcercaDe);
        etFecha = findViewById(R.id.etFecha);
        etValoracion = findViewById(R.id.etValoracion);
        etTelefono = findViewById(R.id.etTelefono);
        etNombre = findViewById(R.id.etNombre);
        etSituacionSpinner = findViewById(R.id.spinnerSituacion);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnMostrarResultados = findViewById(R.id.btnMostrarResultados);

        cuestionarioDAO = new CuestionarioDAO(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCuestionario();
            }
        });

        btnMostrarResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarResultados();
            }
        });
    }

    private void guardarCuestionario() {
        // Obtener datos de los EditText
        String acercaDe = etAcercaDe.getText().toString();
        String fecha = etFecha.getText().toString();
        int valoracion;
        try {
            valoracion = Integer.parseInt(etValoracion.getText().toString());
        } catch (NumberFormatException e) {
            valoracion = 0;
        }
        String telefono = etTelefono.getText().toString();
        String nombre = etNombre.getText().toString();
        String situacion = etSituacionSpinner.getSelectedItem().toString();

        // Crear objeto Cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setAcercaDe(acercaDe);
        cuestionario.setFecha(fecha);
        cuestionario.setValoracion(valoracion);
        cuestionario.setTelefono(telefono);
        cuestionario.setNombre(nombre);
        cuestionario.setSituacion(situacion);

        // Guardar en la base de datos
        cuestionarioDAO.insertarCuestionario(cuestionario);

        // Limpiar los EditText después de guardar
        etAcercaDe.getText().clear();
        etFecha.getText().clear();
        etValoracion.getText().clear();
        etTelefono.getText().clear();
        etNombre.getText().clear();
    }

    private void mostrarResultados() {
        // Obtener todos los cuestionarios almacenados en la base de datos
        List<Cuestionario> cuestionarios = cuestionarioDAO.obtenerTodosCuestionarios();

        // Calcular porcentajes y otras estadísticas según tus requisitos
        int totalClientes = cuestionarios.size();
        int clientesEncantados = 0;
        int clientesDetestaronServicio = 0;
        List<String> clientesQueGustanTodo = new ArrayList<>();
        Map<String, Integer> valoracionesPorFecha = new HashMap<>();

        for (Cuestionario cuestionario : cuestionarios) {
            // Calcular porcentaje de clientes encantados
            if (cuestionario.getValoracion() >= 4) {
                clientesEncantados++;
            }

            // Calcular porcentaje de clientes que detestaron el servicio
            if (cuestionario.getAcercaDe().equals("Servicio") && cuestionario.getValoracion() == 1) {
                clientesDetestaronServicio++;
            }

            // Almacenar nombres de clientes que gustan todo
            if (cuestionario.getValoracion() == 5 && cuestionario.getAcercaDe().equals("Limpieza")
                    && cuestionario.getSituacion().equals("con amigos")) {
                clientesQueGustanTodo.add(cuestionario.getNombre());
            }

            // Realizar seguimiento de valoraciones por fecha
            String fecha = cuestionario.getFecha();
            int valoracion = cuestionario.getValoracion();

            if (valoracionesPorFecha.containsKey(fecha)) {
                valoracionesPorFecha.put(fecha, valoracionesPorFecha.get(fecha) + valoracion);
            } else {
                valoracionesPorFecha.put(fecha, valoracion);
            }
        }

        // Identificar el día con más valoraciones altas
        String mejorDiaComida = obtenerMejorDiaComida(valoracionesPorFecha);

        // Muestra los resultados en la nueva actividad
        String resultado = "Resultados:\n" +
                "Porcentaje de clientes encantados: " + ((float)clientesEncantados / totalClientes) * 100 + "%\n" +
                "Porcentaje de clientes que detestaron el servicio: " + ((float)clientesDetestaronServicio / totalClientes) * 100 + "%\n" +
                "Clientes que gustan de todo: " + clientesQueGustanTodo.toString() + "\n" +
                "Día que más gustó la comida: " + mejorDiaComida;

        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("resultados", resultado);
        startActivity(intent);
    }

    private String obtenerMejorDiaComida(Map<String, Integer> valoracionesPorFecha) {
        // Encuentra el día con más valoraciones altas
        String mejorDia = null;
        int mejorValoracion = 0;

        for (Map.Entry<String, Integer> entry : valoracionesPorFecha.entrySet()) {
            String fecha = entry.getKey();
            int valoracionTotal = entry.getValue();

            if (valoracionTotal > mejorValoracion) {
                mejorValoracion = valoracionTotal;
                mejorDia = fecha;
            }
        }

        return mejorDia != null ? mejorDia : "No se ha calculado";
    }
}
