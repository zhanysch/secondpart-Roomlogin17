package c.sql.ui

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import c.sql.Data.DataBaseAbstrct

class App: Application() {   //(class aplication всегда нужно указыва в манифесте!!!

    private var db: DataBaseAbstrct?=null

    override fun onCreate() {
        super.onCreate()
        app=this
        db= Room.databaseBuilder(this, DataBaseAbstrct :: class.java,"DataBase")
            .allowMainThreadQueries() // эта функц при нажати кнопки сохр, позволяет сохран в главн потоке тоесть внутри телефона. при сохранен внтури телефона телефон зависает
                //  сохранен в главн потоке внутри телефон нежелательно
            .build()
    }

    fun getDB() = db   // эта функц будет возврш БД


    companion object {
        var app: App? = null
    }
}