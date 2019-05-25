package com.stmm.latihanretrofit

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.stmm.latihanretrofit.data.model.Country
import kotlinx.android.synthetic.main.item_liga.view.*

class LigaRecyclerAdapter(private val list: List<Country>) : RecyclerView.Adapter<LigaRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(data: Country) { //di onbind udah jadi country, bukan list
            itemView.textviewLiga.text = data.strLeague
         //   Glide.with(itemView.context).load(data.strBadge)
            Glide.with(itemView.context).load(data.strBadge).into(itemView.imageviewLiga)

            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailLigaActivity::class.java)
                intent.putExtra("data", data)
                itemView.context.startActivity(intent)
            }
            //gunanya ketika item di click, maka akan pindah ke Detailligaactivity
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) //pendeklarasian list layoutnya pake yang mana
            : ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_liga, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size //jumlah listnya ada berapa


    override fun onBindViewHolder(p0: LigaRecyclerAdapter.ViewHolder, p1: Int) = p0.onBind(list[p1])


}