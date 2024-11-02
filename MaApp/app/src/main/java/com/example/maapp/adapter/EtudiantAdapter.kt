package com.example.maapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maapp.R
import com.example.maapp.classes.Etudiant

class EtudiantAdapter(private var etudiants: List<Etudiant>) :
    RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder>() {

    class EtudiantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.etudiant_id) // ID du TextView
        val nom: TextView = itemView.findViewById(R.id.etudiant_nom)
        val prenom: TextView = itemView.findViewById(R.id.etudiant_prenom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EtudiantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_etudiant, parent, false)
        return EtudiantViewHolder(view)
    }

    override fun onBindViewHolder(holder: EtudiantViewHolder, position: Int) {
        val etudiant = etudiants[position]
        holder.id.text = etudiant.id.toString() // Affichage de l'ID
        holder.nom.text = etudiant.nom
        holder.prenom.text = etudiant.prenom
    }

    override fun getItemCount(): Int {
        return etudiants.size
    }

    fun updateList(newEtudiants: List<Etudiant>) {
        etudiants = newEtudiants
        notifyDataSetChanged()
    }
}
