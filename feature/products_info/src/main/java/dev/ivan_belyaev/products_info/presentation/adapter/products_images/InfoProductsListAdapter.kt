package dev.ivan_belyaev.products_info.presentation.adapter.products_images

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ivan_belyaev.products_info.R


class InfoProductsListAdapter :
    ListAdapter<InfoProductsModel, InfoProductsListAdapter.PostersViewHolder>(InfoProductsDiffUtil) {

    class PostersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: InfoProductsModel) {
            try {
                setImage(view.context, model.url, view.findViewById(R.id.item_poster_image_view))
            } catch (e: Exception) {
                Log.d("LOGTAG", e.toString() + e.cause + e.message)
            }
        }

        private fun setImage(context: Context, url: String, imageView: ImageView) {
            Glide
                .with(context)
                .load(url)
                .placeholder(R.drawable.drawable_downloading)
                .error(R.drawable.drawable_error)
                .centerCrop()
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostersViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_info_products_rec_view, viewGroup, false)
        return PostersViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostersViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }
}