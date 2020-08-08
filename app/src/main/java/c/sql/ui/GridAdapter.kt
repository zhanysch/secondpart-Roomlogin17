package c.sql.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import c.sql.Data.DataClassEdit
import c.sql.Data.DataclassLogPass
import c.sql.R
import kotlinx.android.synthetic.main.item_grid.view.*

class GridAdapter(private val  listener: ItemListener):RecyclerView.Adapter<GridAdapter.VHolder>() {
    private var data = arrayListOf<DataClassEdit>()


    /// (private val ^ listener: ItemListener) это значение рядом с GridAdapter чтоб могли созд метод удаления сохр БД

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid,parent,false)
        return VHolder(view)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    fun update (data : List<DataClassEdit>){
        this.data.clear()             // происходит чистка локаль array list
        this.data.addAll(data)        // происходит добавление данных
        notifyDataSetChanged()
    }



    class VHolder(view:View):RecyclerView.ViewHolder(view){
        fun bind(data: DataClassEdit, listener: ItemListener){
            itemView.tv1.text=data.edtOne
            itemView.tv2.text=data.edtTwo

            itemView.btnDelete.setOnClickListener {
                listener.itemClicked(data)
            }
        }
    }
}