package dev.ivan_belyaev.all_products_api.presentation.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ivan_belyaev.all_products.R
import dev.ivan_belyaev.all_products_api.presentation.viewmodel.AllProductsViewModel


class AllProductsListAdapter(private val viewModel: AllProductsViewModel) :
    ListAdapter<AllProductModel, AllProductsListAdapter.PostersViewHolder>(AllProductsDiffUtil) {

    class PostersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(model: AllProductModel) {
            view.findViewById<TextView>(R.id.all_films_textViewUp).text = model.title
            view.findViewById<TextView>(R.id.all_films_textViewDown).text = model.description
            view.findViewById<TextView>(R.id.all_films_textViewMiddle).text =
                model.price.toString() + "$"
            try {
                Glide
                    .with(view.context)
                    .load(model.thumbnail)
                    .placeholder(R.drawable.renew)
                    .error(R.drawable.drawable_error)
                    .centerCrop()
                    .into(view.findViewById(R.id.productImageView))
            } catch (e: Exception) {
                Log.d("LOGTAG", "Ошбика загрузки фото" + e.message + e.cause + e.stackTrace)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostersViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_products_rec_view, viewGroup, false)

        return PostersViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostersViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.findViewById<ConstraintLayout>(R.id.parentLayout).setOnClickListener {
            viewModel.navigateToFilmByIdScreen(model)
        }
        if (position == currentList.lastIndex - 8) {
            viewModel.recyclerViewPagingManager(currentList.size)
        }
    }
}