package com.example.a0413_tab_7

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CommunityWrite : AppCompatActivity() {

    lateinit var back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_write)

        back = findViewById<ImageView>(R.id.back)

        back.setOnClickListener {
            super.onBackPressed()
        }


    }
}