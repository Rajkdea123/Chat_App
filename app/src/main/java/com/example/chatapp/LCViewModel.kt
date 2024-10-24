package com.example.chatapp

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.log

class LCViewModel :ViewModel(

)
val auth:FirebaseAuth
{

    fun SignUp(name:String,number: String,email:String,password:String){
      auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
          if (it.isSuccessful){
             log.d()
          }
      }

    }
}