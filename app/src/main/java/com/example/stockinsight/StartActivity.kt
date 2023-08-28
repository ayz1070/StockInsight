package com.example.stockinsight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.stockinsight.databinding.ActivityStartBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

class StartActivity : AppCompatActivity() {


    // -----------------------------------
    lateinit var binding:ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try{
                val account = task.getResult((ApiException::class.java))
                val credential = GoogleAuthProvider
                    .getCredential(account.idToken,null)
                MyApplication.auth.signInWithCredential(credential)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            // 성공 시
                            MyApplication.email = account.email
                            Log.d("로그인","로그인 성공")

                        }else{
                            Log.w("로그인","로그인 실패",task.exception)
                        }

                    }
            }catch(e:ApiException){
                Log.w("로그인","로그인 실패",e)
            }
        }

        binding.btnGoogle.setOnClickListener{
            val gso=GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build()
            val signInIntent = GoogleSignIn.getClient(this,gso).signInIntent
            requestLauncher.launch(signInIntent)
        }
    }
}