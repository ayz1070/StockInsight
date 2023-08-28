package com.example.stockinsight

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stockinsight.databinding.ActivityProfileSettingBinding

class ProfileSettingActivity : AppCompatActivity() {
    lateinit var sharedPref:SharedPreferences
    lateinit var nickname:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("profile_prefs",Context.MODE_PRIVATE)

        binding.btnNext.setOnClickListener{
            sharedPref.edit().run{
                putString("nickname","nickname")
            }
        }
    }
}