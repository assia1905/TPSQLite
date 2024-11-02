package com.example.maapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.maapp.classes.Etudiant
import com.example.maapp.service.EtudiantService

class AddEtudiantActivity : AppCompatActivity() {

    private lateinit var etNom: EditText
    private lateinit var etPrenom: EditText
    private lateinit var btnSave: Button
    private lateinit var es: EtudiantService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_etudiant)

        es = EtudiantService(this)

        etNom = findViewById(R.id.et_nom)
        etPrenom = findViewById(R.id.et_prenom)
        btnSave = findViewById(R.id.btn_save)

        btnSave.setOnClickListener {
            val nom = etNom.text.toString().trim()
            val prenom = etPrenom.text.toString().trim()

            if (nom.isEmpty() || prenom.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else {
                val etudiant = Etudiant(nom = nom, prenom = prenom)
                es.create(etudiant)  // Ajout de l'étudiant à votre service
                Toast.makeText(this, "Étudiant ajouté avec succès", Toast.LENGTH_SHORT).show()
                finish()  // Retour à MainActivity
            }
        }
    }
}
