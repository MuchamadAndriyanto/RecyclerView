package com.example.chapter3topic5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter (var listStudent: ArrayList<ListStudent>): RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    var onClick : ((ListStudent) -> Unit)? = null
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var nama = view.findViewById<TextView>(R.id.txtNama)
        var umur = view.findViewById<TextView>(R.id.txtUmur)
        var img = view.findViewById<ImageView>(R.id.imgStudent)
        var card = view.findViewById<CardView>(R.id.detailCard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.nama.text = listStudent[position].nama
        holder.umur.text = listStudent[position].umur.toString()
        holder.img.setImageResource(listStudent[position].img)
        holder.card.setOnClickListener{
            onClick?.invoke(listStudent[position])
        }

    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

}