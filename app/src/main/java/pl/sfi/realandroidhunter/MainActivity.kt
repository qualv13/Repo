package pl.sfi.realandroidhunter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.net.toUri
import pl.sfi.realandroidhunter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //ta klasa nie moze byc nigdy nullem
    private val mainVm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //rozdmuchowywanie - czytanie xml na kotlin

        Log.d("TAG", "OnCreate")

        binding.loginBtn.setOnClickListener{
            val login = binding.loginEt.text.toString()
            val password = binding.passEt.text.toString()


            val user = mainVm.tryLogin(login, password)
            if(user != null){
                openHomeActivity()
            }else{
                Toast.makeText(applicationContext, "Błędny: $login \n I haslo: $password",
                    Toast.LENGTH_LONG).show()
            }
        }

        //binding.loginBtn.setOnLongClickListener{

        //}

    }
    private fun openHomeActivity(){
        val sfiurl = "https://sfi.pl/pl/"
        val intent = Intent(Intent.ACTION_VIEW)
            .apply {
                data = sfiurl.toUri()
            }
        startActivity(intent)
    }
}