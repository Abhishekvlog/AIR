package com.dexter.air.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dexter.air.R
import com.dexter.air.model.local.SessionEntity
import kotlinx.android.synthetic.main.item_detail.view.*

class DetailAdapter(val sessionList: ArrayList<SessionEntity>) : RecyclerView.Adapter<DetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail,parent,false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.setData(sessionList[position])
    }

    override fun getItemCount(): Int {
        return sessionList.size
    }
}
class DetailViewHolder(val item : View) : RecyclerView.ViewHolder(item){
    fun setData(sessionEntity: SessionEntity) {
        item.apply {
            date_View.text = "${sessionEntity.date } Mar 2022"
            session_View.text = "${sessionEntity.session }"
        }
    }

}