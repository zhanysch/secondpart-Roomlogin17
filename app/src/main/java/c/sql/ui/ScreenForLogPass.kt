package c.sql.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import c.sql.App
import c.sql.Data.DataBaseAbstrct
import c.sql.Data.DataClassEdit
import c.sql.Data.DataclassLogPass
import c.sql.R
import kotlinx.android.synthetic.main.activity_screen_for_log_pass.*
import kotlinx.android.synthetic.main.activity_show.*

class ScreenForLogPass : AppCompatActivity() {
    private var db: DataBaseAbstrct?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_for_log_pass)
        db = App.app?.getDB()
        Listeners()
    }

    private fun Listeners() {

        btnLogin.setOnClickListener {
            val result = App.app?.getDB()?.getDaoInterf()?.getEditfromdata()?.last()
            EdOne.setText(result?.edlog)
            EdTwo.setText(result?.edpass)

            if ( result?.edpass == EdTwo.text.toString() && result?.edlog == EdOne.text.toString())
            { EdOne.setText(result?.edlog)
                EdTwo.setText(result?.edpass)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else  {
                Toast.makeText(this, "Данные не верны", Toast.LENGTH_LONG).show()
            }
        }

        btnSave.setOnClickListener {
            if (isEdNotEmpty()){
                App.app?.getDB()?.getDaoInterf()?.saveforScreenLogPAss(
                    DataclassLogPass(
                    edlog = EdOne.text.toString(),
                    edpass = EdTwo.text.toString())
                )
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
              }else{
                Toast.makeText(this, "Введите данные", Toast.LENGTH_LONG).show()
              }
        }
    }

    private fun isEdNotEmpty(): Boolean{   //Boolean проверяет return log && pass
        val login = EdOne.text.toString().length > 4  // (length > 4 текст должен быть больше 4 символов
        val pass = EdTwo.text.toString().length > 5

        return login && pass
    }

}
