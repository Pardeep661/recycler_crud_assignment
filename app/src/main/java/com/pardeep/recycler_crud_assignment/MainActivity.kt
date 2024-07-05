package com.pardeep.recycler_crud_assignment

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pardeep.recycler_crud_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerInterface {

    var binding : ActivityMainBinding? = null
    var data = arrayListOf<MyData>()
    var recycAdapter = MyAdapter(this,data,this)
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dataBase: DataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dataBase = DBHandler.getDB(this)

        binding?.fab?.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.custom_dialog)
                window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                var text1 = findViewById<TextView>(R.id.editTextText)
                var text2 = findViewById<TextView>(R.id.editTextText2)
                var add = findViewById<Button>(R.id.Add)

                add?.setOnClickListener {
                    if(text1.text.trim().isNullOrEmpty()){
                        text1.error = "enter title"
                    }else if (text2.text.trim().isNullOrEmpty()){
                        text2.error = "enter description"
                    }else
                    {
                        dataBase.dataDao.insertData(MyData(title = text1.text.toString(), description = text2.text.toString()))
                        println(dataBase.dataDao.getAllData())
                        data.add(MyData(text1.text.toString(),text2.text.toString()))
                        recycAdapter.notifyDataSetChanged()
                        dismiss()
                    }
                }
            }.show()
        }


        data.add(MyData(title = "name", description = "jalandhar"))
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding?.rv?.layoutManager = linearLayoutManager
        binding?.rv?.adapter = recycAdapter


    }

    override fun delete(position: Int) {
        data.removeAt(position)
        recycAdapter.notifyDataSetChanged()
    }

    override fun update(position: Int) {
       Dialog(this).apply {
           setContentView(R.layout.custom_dialog)
           window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
           var text1 = findViewById<EditText>(R.id.editTextText)
           var text2 = findViewById<EditText>(R.id.editTextText2)
           var add = findViewById<Button>(R.id.Add)

           text1.setText(data[position].title)
           text2.setText(data[position].description)

           add?.setOnClickListener {
               if(text1.text.trim().isNullOrEmpty()){
                   text1.error = "enter title"
               }else if (text2.text.trim().isNullOrEmpty()){
                   text2.error = "enter description"
               }else
               {
                   //data.set(position,MyData(text1.text.toString(),text2.text.toString()))
                   //recycAdapter.notifyDataSetChanged()
                   dismiss()
               }
           }
       }.show()
    }


}