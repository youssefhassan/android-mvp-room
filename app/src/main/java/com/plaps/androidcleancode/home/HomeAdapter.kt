package com.plaps.androidcleancode.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.plaps.androidcleancode.R
import com.plaps.androidcleancode.models.CityListData

class HomeAdapter internal constructor(
        private val context: Context,
        private val data: List<CityListData>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, null)
        view.layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        )

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.click(data[position], listener)
        holder.tvCity.text = data[position].name
        holder.tvDesc.text = data[position].description

        val images = data[position].background

        Glide.with(context)
                .load(images)
                .apply(RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                .into(holder.background)

    }


    override fun getItemCount(): Int {
        return data.size
    }


    interface OnItemClickListener {
        fun onClick(Item: CityListData)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tvCity: TextView
        internal var tvDesc: TextView
        internal var background: ImageView

        init {
            tvCity = itemView.findViewById(R.id.city)
            tvDesc = itemView.findViewById(R.id.hotel)
            background = itemView.findViewById(R.id.image)

        }


        internal fun click(cityListData: CityListData, listener: OnItemClickListener) {
            itemView.setOnClickListener { listener.onClick(cityListData) }
        }
    }


}
