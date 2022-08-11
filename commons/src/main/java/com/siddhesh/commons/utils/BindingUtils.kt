package com.siddhesh.commons.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestListener
import com.siddhesh.commons.R


class BindingUtils {


    companion object {
        private const val BACKGROUND_COLOR : String= "setBackgroundColor"
        private const val LOAD_IMAGE : String= "loadImage"
        private const val IMAGE_LISTENER : String= "imageListener"


        @JvmStatic
        @BindingAdapter(BACKGROUND_COLOR)
        fun setBackgroundColor(view: View, color: Int) {
            if (color != 0) {
                view.setBackgroundColor(color)
            }
        }
        @JvmStatic
        @BindingAdapter(LOAD_IMAGE,IMAGE_LISTENER)
        fun setLoadImage(view: ImageView, url: String?,listener: RequestListener<Drawable>?) {

            url?.let {
                Glide.with(view.context).load(url)
                    .listener(listener)
                    .thumbnail(Glide.with(view.context).load(R.drawable.loading))
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(view);
            }

        }
    }
}