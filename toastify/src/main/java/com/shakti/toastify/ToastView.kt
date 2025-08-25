package com.shakti.toastify

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView

class ToastView(context: Context) : FrameLayout(context) {

    private val card: MaterialCardView
    private val icon: ImageView
    private val message: TextView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_toast, this, true)
        card = view.findViewById(R.id.toastCard)
        icon = view.findViewById(R.id.toastIcon)
        message = view.findViewById(R.id.toastMessage)
    }

    fun bind(type: ToastType, text: String) {
        message.text = text
        when (type) {
            ToastType.SUCCESS -> {
                card.setCardBackgroundColor(Color.parseColor("#388E3C"))
                this.icon.setImageResource(android.R.drawable.ic_dialog_info)
            }
            ToastType.ERROR -> {
                card.setCardBackgroundColor(Color.parseColor("#D32F2F"))
                this.icon.setImageResource(android.R.drawable.ic_dialog_info)
            }
            ToastType.NEUTRAL -> {
                card.setCardBackgroundColor(Color.parseColor("#455A64"))
                this.icon.setImageResource(android.R.drawable.ic_dialog_info)
            }
        }
    }
}
