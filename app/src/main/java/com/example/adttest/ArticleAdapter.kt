package com.example.adttest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adttest.retrofit.Article

class ArticlesAdapter(private val articles: MutableList<Article?>?, private val context: Context) :
    RecyclerView.Adapter<ArticlesAdapter.ArticleHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.article_list_item, parent, false)
        return ArticleHolder(view)
    }

    override fun getItemCount(): Int {
        return articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.bind(articles?.get(position), context)
    }

    class ArticleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title_article)
        val background = itemView.findViewById<ImageView>(R.id.img_article)

        fun bind(article: Article?, context: Context) {
            title.text = article?.title
            Glide.with(context).load(article?.urlToImage).centerCrop().placeholder(android.R.drawable.stat_sys_download).into(background)
        }
    }
}