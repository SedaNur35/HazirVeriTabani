package com.example.hazirveritabani.dao

import android.annotation.SuppressLint
import com.example.hazirveritabani.VeritabaniYardimcisi
import com.example.hazirveritabani.siniflar.Filmler
import com.example.hazirveritabani.siniflar.Kategoriler
import com.example.hazirveritabani.siniflar.Yonetmenler

class Filmlerdao {



    @SuppressLint("Range")
    fun tumFilmler(vt: VeritabaniYardimcisi,kategori_id:Int):ArrayList<Filmler>{
        val filmlerliste= ArrayList<Filmler>()
        val db =vt.writableDatabase
        val cursor =db.rawQuery("SELECT *FROM filmler,kategoriler,yonetmenler WHERE\n" +
                "     filmler.kategori_id=kategoriler.kategori_id and\n" +
                "     filmler.yonetmen_id= yonetmenler.yonetmen_id and filmler.kategori_id=$kategori_id",null)
        while (cursor.moveToNext()){
            val kategoriler = Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id"))
                ,cursor.getString(cursor.getColumnIndex("kategori_ad"))
            )
            val yonetmenler = Yonetmenler(cursor.getInt(cursor.getColumnIndex("yonetmen_id"))
                ,cursor.getString(cursor.getColumnIndex("yonetmen_ad"))
            )

            val film =Filmler(cursor.getInt(cursor.getColumnIndex("film_id")),
                cursor.getString(cursor.getColumnIndex("film_ad")),
                cursor.getInt(cursor.getColumnIndex("film_yil"))
            ,cursor.getString(cursor.getColumnIndex("film_resim")),kategoriler,yonetmenler
                )
            filmlerliste.add(film)

        }
        return filmlerliste
    }
}