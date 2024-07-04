package com.pardeep.recycler_crud_assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    var context: Context,
    var list:ArrayList<MyData>,
    var recyclerInterface: RecyclerInterface
) : RecyclerView.Adapter<MyAdapter.viewHolder>() {



    class viewHolder (var view : View) : RecyclerView.ViewHolder(view) {
        var tittle_text = view.findViewById<TextView>(R.id.Title)
        var descriptor_text = view.findViewById<TextView>(R.id.Description)
        var delete = view.findViewById<Button>(R.id.delete)
        var update = view.findViewById<Button>(R.id.Update)

    }


    // this method is used for holding the view accordig to user screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.viewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.single_row_desgin,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.viewHolder, position: Int) {
       holder.tittle_text.setText(list[position].title)
        holder.descriptor_text.setText(list[position].description)

        holder.delete.setOnClickListener {
            recyclerInterface.delete(position)
        }
        holder.update.setOnClickListener {
            recyclerInterface.update(position)
        }


        //even old color
        if(position % 2 ==0){
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.Red))
        }
    }

    override fun getItemCount(): Int {
        return list.size

    }

}
