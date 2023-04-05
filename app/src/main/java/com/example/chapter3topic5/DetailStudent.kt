package com.example.chapter3topic5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic5.databinding.ActivityDetailStudentBinding
import com.example.chapter3topic5.databinding.ActivityMainBinding

class DetailStudent : AppCompatActivity() {
    lateinit var binding : ActivityDetailStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getDetail = intent.getSerializableExtra("detailStudent") as ListStudent
        binding.detailImg.setImageResource(getDetail.img)
        binding.detailNama.text = getDetail.nama
        binding.detailUmur.setText (getDetail.umur.toString())
    }
}