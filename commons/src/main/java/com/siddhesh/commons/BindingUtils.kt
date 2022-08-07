package com.siddhesh.commons

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class BindingUtils {


    companion object {
        private const val BACKGROUND_COLOR : String= "setBackgroundColor"
        private const val LOAD_IMAGE : String= "loadImage"


        @JvmStatic
        @BindingAdapter(BACKGROUND_COLOR)
        fun setBackgroundColor(view: View, color: Int) {
            if (color != 0) {
                view.setBackgroundColor(color)
            }
        }
        @JvmStatic
        @BindingAdapter(LOAD_IMAGE)
        fun setLoadImage(view: ImageView, url: String) {
            if(url ==null){
                return
            }
            Glide.with(view.context).load(url)
                .thumbnail(Glide.with(view.context).load(R.drawable.loading))
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(view);
        }
    }
}