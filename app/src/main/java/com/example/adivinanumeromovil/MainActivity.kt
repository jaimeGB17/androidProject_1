package com.example.adivinanumeromovil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var num_aleatorio = Random.nextInt(1, 11)
        //Recoger la referencia del boton
        val boton_adivina: Button = findViewById(R.id.boton)
        val campo_texto: EditText = findViewById(R.id.campo_texto_numero)

        boton_adivina.setOnClickListener {
            //Recogemos el valor del campo de texto
            var valor: Int = Integer.parseInt(campo_texto.text.toString())
            if (valor > num_aleatorio) {
                Toast.makeText(this, "El numero oculto es menor", Toast.LENGTH_LONG).show()
            } else
                if (valor < num_aleatorio) {
                    Toast.makeText(this, "El numero oculto es mayor", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, this.getString(R.string.mensaje_ganador), Toast.LENGTH_LONG)
                        .show()
                    //creación del dialog para volver a jugar
                    val myDialog: AlertDialog.Builder = AlertDialog.Builder(this)
                    myDialog.setTitle("JUGAR")
                    myDialog.setMessage("¿Quieres seguir jugando?")
                    myDialog.setPositiveButton("SI", { dialog, which ->
                        // para volver a jugar necesitamos cambiar el numero aleatorio y el texto.
                        num_aleatorio = Random.nextInt(1, 11)
                        campo_texto.setText("")
                    })
                    //en caso de que no queramos seguir jugando, que finalize la aplicación
                    myDialog.setNegativeButton("NO", { dialog, which ->
                       finish()
                    })
                    //aqui creamos el dialog y lo mostramos
                    val dialog: AlertDialog=myDialog.create()
                    dialog.show()
                }
        }
    }
}