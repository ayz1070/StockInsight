package com.example.stockinsight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stockinsight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.bot_home -> transaction.replace(R.id.fl_main, HomeFragment())
                R.id.bot_bookmark -> transaction.replace(R.id.fl_main, BookmarkFragment())
                R.id.bot_mypage -> transaction.replace(R.id.fl_main, MyPageFragment())
            }
            transaction.commit()
            true
        }
    }
}