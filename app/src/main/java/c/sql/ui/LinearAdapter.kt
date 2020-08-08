package c.sql.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import c.sql.Data.DataclassLogPass
import c.sql.R
import kotlinx.android.synthetic.main.item_grid.view.*
import kotlinx.android.synthetic.main.item_linear.view.*

class LinearAdapter(private val  listen: ItemListener):RecyclerView.Adapter<LinearAdapter.ShowVh>() {
    private var list = arrayListOf<DataclassLogPass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowVh {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_linear,parent, false)

     return ShowVh(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun update (list:List<DataclassLogPass>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ShowVh, position: Int) {
       holder.bind(list[position],listen)
    }





    class ShowVh(view:View):RecyclerView.ViewHolder(view){
        fun bind (item: DataclassLogPass,  listen: ItemListener){
            itemView.text1.text=item.edlog
           itemView.BtnDelete.setOnClickListener {
               listen.itemClicks(item)
           }

        }
    }
}


