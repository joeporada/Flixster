package com.example.flixster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val context: Context, private val movies: List<Movie>, private val ori: String)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)

        fun bind(movie: Movie){
            Glide.with(context).load("http://via.placeholder.com/300.png").into(ivPoster)
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            if(ori == "port"){
                Glide.with(context).load(movie.posterImageUrl).placeholder(R.drawable.loading).into(ivPoster)}
            else if(ori == "land"){
                Glide.with(context).load(movie.backdropImageUrl).into(ivPoster)}
        }
    }

}