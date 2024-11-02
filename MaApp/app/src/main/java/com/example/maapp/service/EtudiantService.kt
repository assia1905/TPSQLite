package com.example.maapp.service

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.maapp.classes.Etudiant
import com.example.maapp.util.MySQLiteHelper

class EtudiantService(context: Context) {
    private val helper = MySQLiteHelper(context)

    fun create(etudiant: Etudiant) {
        helper.writableDatabase.use { db ->
            val values = ContentValues().apply {
                put(MySQLiteHelper.KEY_NOM, etudiant.nom)
                put(MySQLiteHelper.KEY_PRENOM, etudiant.prenom)
            }
            db.insert(MySQLiteHelper.TABLE_NAME, null, values)
        }
    }

    fun update(etudiant: Etudiant) {
        helper.writableDatabase.use { db ->
            val values = ContentValues().apply {
                put(MySQLiteHelper.KEY_NOM, etudiant.nom)
                put(MySQLiteHelper.KEY_PRENOM, etudiant.prenom)
            }
            db.update(MySQLiteHelper.TABLE_NAME, values, "${MySQLiteHelper.KEY_ID} = ?", arrayOf(etudiant.id.toString()))
        }
    }

    fun findById(id: Int): Etudiant? {
        helper.readableDatabase.use { db ->
            val cursor = db.query(MySQLiteHelper.TABLE_NAME, arrayOf(MySQLiteHelper.KEY_ID, MySQLiteHelper.KEY_NOM, MySQLiteHelper.KEY_PRENOM), "${MySQLiteHelper.KEY_ID} = ?", arrayOf(id.toString()), null, null, null)
            return if (cursor.moveToFirst()) {
                Etudiant(cursor.getInt(0), cursor.getString(1), cursor.getString(2))
            } else {
                null
            }
        }
    }

    fun delete(etudiant: Etudiant) {
        helper.writableDatabase.use { db ->
            db.delete(MySQLiteHelper.TABLE_NAME, "${MySQLiteHelper.KEY_ID} = ?", arrayOf(etudiant.id.toString()))
        }
    }

    fun findAll(): List<Etudiant> {
        val etudiants = mutableListOf<Etudiant>()
        helper.readableDatabase.use { db ->
            val cursor: Cursor = db.rawQuery("SELECT * FROM ${MySQLiteHelper.TABLE_NAME}", null)
            while (cursor.moveToNext()) {
                etudiants.add(Etudiant(cursor.getInt(0), cursor.getString(1), cursor.getString(2)))
            }
            cursor.close()
        }
        return etudiants
    }
}
