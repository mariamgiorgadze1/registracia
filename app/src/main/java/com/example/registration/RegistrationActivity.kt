package com.example.kai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registration.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegistration.setOnClickListener {

            val email= editTextEmail.text.toString()
            val password= editTextPassword.text.toString()

            if(email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this,"ცარიელია ველები",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"წარმატებით შეიქმნა!",Toast.LENGTH_SHORT).show()

                    }
                    else {
                        Toast.makeText(this,"ფორმატის შეცდომა",Toast.LENGTH_SHORT).show()
                    }
                }

        }

        }
    }
