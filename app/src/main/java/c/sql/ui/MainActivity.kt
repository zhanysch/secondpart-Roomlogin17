package c.sql.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import c.sql.App
import c.sql.Data.DataBaseAbstrct
import c.sql.Data.DataClassEdit
import c.sql.Data.DataclassLogPass
import c.sql.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemListener {

    private var db: DataBaseAbstrct?=null // благодаря db: DataBaseAbstrct? осушеств передача таблиц

    private var  adapterGrd :GridAdapter? = null  // делаетс глобал, для возможн перезаписать
    val adapter = LinearAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = App.app?.getDB()

        recyclers()
        recycadapt()
    }


    private fun recyclers() {
        val Gridmanager =  GridLayoutManager(applicationContext, 2)   // (Gridmanager -переменная
        recycler.layoutManager = Gridmanager            // где recycler это id
         adapterGrd = GridAdapter(this)      //adapterGrd это переменная // (this)  для функции удаления кнопки delete
        recycler.adapter = adapterGrd
        val data = db?.getDaoInterf()?.getallEditFromDataclass()

        if (data!=null)                               // проверка что data не = null, т.к adapterGrd.update(data) выходит ошибка
            adapterGrd?.update(data)
    }

    override fun itemClicked(data: DataClassEdit) {
        db?.getDaoInterf()?.delete(data)
        val newdata = db?.getDaoInterf()?.getallEditFromDataclass()
        if (newdata!=null)
            adapterGrd?.update(newdata)
    }




    private fun recycadapt() {
        recl.adapter = adapter
        val list = db?.getDaoInterf()?.getEditfromdata()
        if (list!=null)
            adapter.update(list)
    }

    override fun itemClicks(data1: DataclassLogPass) {
        db?.getDaoInterf()?.delete2(data1)
        val newdate = db?.getDaoInterf()?.getEditfromdata()
        if (newdate!=null)
            adapter?.update(newdate)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add -> {

                this.startActivity(Intent(this, ShowActivity :: class.java))
                Toast.makeText(this, "переход на следующую страницу " , Toast.LENGTH_SHORT).show()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}