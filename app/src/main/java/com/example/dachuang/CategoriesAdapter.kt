package com.example.dachuang

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.categorie)
        val background: LinearLayout = itemView.findViewById(R.id.backgroud)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fenlei, parent, false)
        val background: LinearLayout = view.findViewById(R.id.backgroud)
        val text: TextView = view.findViewById(R.id.categorie)
        background.setOnClickListener {
            it.setBackgroundColor(Color.rgb(50, 0, 115))
            text.setTextColor(Color.rgb(255, 255, 255))
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = "test$position"
    }

    override fun getItemCount(): Int {
        return 5;
    }

}