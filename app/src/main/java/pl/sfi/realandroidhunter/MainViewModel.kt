package pl.sfi.realandroidhunter

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() { //ta klasa przetrwa obrót ekranu bo trzyma w ramie
    private val server = Server()

    /*fun login(login: String, password: String){
        return login == correctLogin && password==correctPassword
    }*/
    fun tryLogin(login: String, password: String): User?{
        val succes = server.tryLogin(login, password)
        return if(succes) User("Jan", "kowalski@wp.pl")
        else null
    }
}