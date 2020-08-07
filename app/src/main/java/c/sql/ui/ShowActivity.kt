package c.sql.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.sql.App
import c.sql.Data.DataBaseAbstrct
import c.sql.Data.DataClassEdit
import c.sql.R
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
   private var db: DataBaseAbstrct?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        listener()
        db = App.app?.getDB()
    }


    private fun listener(){
        BtnSave.setOnClickListener {
            db?.getDaoInterf()?.insertDataClassEdit(forlistener())  // (insert from Interfac. // getDaoInterf funct from databaseAbstract)
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun forlistener(): DataClassEdit{
        return DataClassEdit(
            edtOne  = EdtOne.text.toString(), //(edtOne, edtTwo from DataClass)
            edtTwo = EdtTwo.text.toString()  // (EdtOne, EdtTwo , from activity_showhml)
        )
    }
}
