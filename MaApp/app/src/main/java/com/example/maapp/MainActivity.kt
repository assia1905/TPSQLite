package com.example.maapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maapp.adapter.EtudiantAdapter
import com.example.maapp.classes.Etudiant
import com.example.maapp.service.EtudiantService


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: Button
    private lateinit var btnSearch: Button
    private lateinit var btnDelete: Button
    private lateinit var etSearchId: EditText
    private lateinit var es: EtudiantService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        es = EtudiantService(this)

        recyclerView = findViewById(R.id.recycler_view)
        btnAdd = findViewById(R.id.btn_add)
        btnSearch = findViewById(R.id.btn_search)
        btnDelete = findViewById(R.id.btn_delete)
        etSearchId = findViewById(R.id.et_search_id)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = EtudiantAdapter(es.findAll())
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener {
            val intent = Intent(this, AddEtudiantActivity::class.java)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            val id = etSearchId.text.toString().toIntOrNull()
            if (id != null) {
                val etudiant = es.findById(id)
                if (etudiant != null) {
                    Toast.makeText(this, "Étudiant trouvé: ${etudiant.nom} ${etudiant.prenom}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Étudiant non trouvé", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Veuillez entrer un ID valide", Toast.LENGTH_SHORT).show()
            }
        }

        btnDelete.setOnClickListener {
            val id = etSearchId.text.toString().toIntOrNull()
            if (id != null) {
                val etudiant = es.findById(id)
                if (etudiant != null) {
                    es.delete(etudiant)
                    Toast.makeText(this, "Étudiant supprimé avec succès", Toast.LENGTH_SHORT).show()
                    (recyclerView.adapter as EtudiantAdapter).updateList(es.findAll())
                } else {
                    Toast.makeText(this, "Étudiant non trouvé", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Veuillez entrer un ID valide", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (recyclerView.adapter as EtudiantAdapter).updateList(es.findAll())
    }
}
