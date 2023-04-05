package com.example.chapter3topic5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter3topic5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listStudentData = arrayListOf(
            ListStudent("Andriyan", 20, R.drawable.baseline_castle_24),
            ListStudent("Rizki", 20, R.drawable.baseline_castle_24),
            ListStudent("Dwiki", 27, R.drawable.baseline_castle_24),
            ListStudent("Rizki", 20, R.drawable.baseline_castle_24),
            ListStudent("Ajeng", 19, R.drawable.baseline_castle_24),
            ListStudent("Nanda", 20, R.drawable.baseline_castle_24),
            ListStudent("Dian", 19, R.drawable.baseline_castle_24)
        )

        var adapterStudent = StudentAdapter(listStudentData)


        //mengatur tataletak dari viewnya
        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //val gl = GridLayout(this)
        binding.rvStudent.layoutManager = lm
        binding.rvStudent.adapter = adapterStudent

        adapterStudent.onClick = {
            val pindah = Intent(this, DetailStudent::class.java)
            pindah.putExtra("detailStudent", it)
            startActivity(pindah)
        }


        //update data
        binding.btnUpdate.setOnClickListener {
            listStudentData[1] = ListStudent("Update Data JOKO", 25, R.drawable.baseline_commit_24)
            var adapterStudentdiff = StudentAdapterDiffUtill()
            adapterStudentdiff.submitData(listStudentData)
            binding.rvStudent.adapter = adapterStudentdiff

            adapterStudentdiff.onClick = {
                val pindah = Intent(this, DetailStudent::class.java)
                pindah.putExtra("detailStudent", it)
                startActivity(pindah)

            }

        }

    }
}