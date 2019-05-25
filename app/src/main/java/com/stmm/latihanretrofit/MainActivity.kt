package com.stmm.latihanretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.stmm.latihanretrofit.data.ApiServiceImpl
import com.stmm.latihanretrofit.data.model.DataLiga
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData() {
        ApiServiceImpl.create()
            .getDataLiga("England", "Soccer")
            //si enqueue untuk nge send request ke server lalu dapat notifikasi respon dari
            //servernya, lalu kalo gagal gimana dan kalo berhasil gimana.
            .enqueue(object : Callback<DataLiga> {
                override fun onFailure(call: Call<DataLiga>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Log.e("APAYANGSALAH", t.localizedMessage)
                }

                //digunakan kalau ada yang error , bisa cek di logcat APAYANGSALAH biar tau mana yang salah
                override fun onResponse(call: Call<DataLiga>, response: Response<DataLiga>) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        val adapter = LigaRecyclerAdapter(response.body()?.countrys!!)
                        recyclerView.adapter = adapter
                        //data recyclerview pake adapter ini
                    }
                }
            })
    }
}
