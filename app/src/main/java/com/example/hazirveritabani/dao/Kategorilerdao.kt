package com.example.hazirveritabani.dao

import android.annotation.SuppressLint
import com.example.hazirveritabani.VeritabaniYardimcisi
import com.example.hazirveritabani.siniflar.Kategoriler

class Kategorilerdao {

    @SuppressLint("Range")
    fun tumkategoriler(vt:VeritabaniYardimcisi):ArrayList<Kategoriler>{
        val kategoriliste= ArrayList<Kategoriler>()
        val db =vt.writableDatabase
             val cursor =db.rawQuery("SELECT * FROM kategoriler",null)
              while (cursor.moveToNext()){
                val kategoriler =Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id"))
                ,cursor.getString(cursor.getColumnIndex("kategori_ad"))
                )
                  kategoriliste.add(kategoriler)

              }
        return  kategoriliste
    }
}