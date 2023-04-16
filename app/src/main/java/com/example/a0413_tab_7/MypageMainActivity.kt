package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.a0413_tab_7.R

class MypageMainActivity : AppCompatActivity() {

    lateinit var Editprofile: Button
    lateinit var writelist: Button
    lateinit var mypagelogout: Button
    lateinit var mypageout: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_main)

        Editprofile = findViewById(R.id.Editprofile)
        writelist = findViewById(R.id.writelist)
        mypagelogout = findViewById(R.id.mypagelogout)
        mypageout = findViewById(R.id.mypageout)

        Editprofile.setOnClickListener {
            val intent = Intent(this, ProfileChangeActivity::class.java)
            startActivity(intent)
        }
        writelist.setOnClickListener {
            val intent = Intent(this, MypageCommunityActivity::class.java)
            startActivity(intent)
        }

    }
}