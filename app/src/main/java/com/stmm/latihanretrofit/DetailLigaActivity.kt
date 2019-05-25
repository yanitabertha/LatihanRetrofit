package com.stmm.latihanretrofit

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.stmm.latihanretrofit.data.model.Country
import kotlinx.android.synthetic.main.activity_detail_liga.*

class DetailLigaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_liga)
        //deklarasi variable model untuk menyimpan data
        var data : Country? = null
        //mengecek intent ada isinya atau tidak
        if (intent.hasExtra("data")){
            data = intent.getParcelableExtra("data")
        }
        Glide.with(this).load(data?.strFanart1).into(imageviewBanner)
        textviewLiga.text = data?.strLeague
        textviewDeskripsi.text = data?.strDescriptionEN
        // di cek ada extra nya ato gak, kalo ada, maka akan di parse.
    }
}

//dibuat dalam package2 adalah karena design pattern.
//MVC kalo di framework
//memisah antara logic aplikasi dan tampilannya
//ada MVP dan MVVM