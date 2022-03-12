package com.example.hazirveritabani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hazirveritabani.dao.Filmlerdao
import com.example.hazirveritabani.dao.Kategorilerdao
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veritabaniKopyala()
        val vt =VeritabaniYardimcisi(this)
      //  val liste =Kategorilerdao().tumkategoriler(vt)
        val liste = Filmlerdao().tumFilmler(vt,2)
         for (k in liste){
             Log.e("Film id",k.film_id.toString())
             Log.e("Film ad",k.film_ad)
             Log.e("Film yil",k.film_yil.toString())
             Log.e("Film resim",k.film_resim)
             Log.e("Kategori ad",k.kategori.kategori_ad)
             Log.e("kategori id",k.kategori.kategori_id.toString())
             Log.e("Yonetmen ad",k.yonetmen.yonetmen_ad)
             Log.e(" yonetmen id",k.yonetmen.yonetmen_id.toString())


         }
    }

    fun veritabaniKopyala(){
        val db =DatabaseCopyHelper(this)


        try {
            db.createDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
        try {
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}