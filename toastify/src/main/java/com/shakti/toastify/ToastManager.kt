package com.shakti.toastify

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import java.util.LinkedList
import java.util.Queue

object ToastManager {
    private val queue: Queue<() -> Unit> = LinkedList()
    private var isShowing = false


    fun showToast(
        activity: Activity,
        message: String,
        type: ToastType,
        duration: Long = 3000L,
        top: Boolean = false
    ) {
        queue.offer { showInternal(activity, message, type, duration, top) }
        if (!isShowing) dequeue()
    }

    private fun dequeue() {
        if (queue.isNotEmpty()) queue.poll()?.invoke() else isShowing = false
    }

    private fun showInternal(
        activity: Activity,
        message: String,
        type: ToastType,
        duration: Long,
        top: Boolean
    ) {
        isShowing = true
        val rootView = activity.findViewById<ViewGroup>(android.R.id.content)

        val toastView = ToastView(activity).apply {
            bind(type, message)
            visibility = View.INVISIBLE
        }

        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = if (top) Gravity.TOP or Gravity.CENTER_HORIZONTAL
            else Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            setMargins(32, 64, 32, 64)
        }

        rootView.addView(toastView, params)

        toastView.alpha = 0f
        toastView.translationY = if (top) -100f else 100f
        toastView.visibility = View.VISIBLE

        // Animate in
        toastView.animate().alpha(1f).translationY(0f).setDuration(300).withEndAction {
            toastView.postDelayed({
                // Animate out
                toastView.animate()
                    .alpha(0f)
                    .translationY(if (top) -100f else 100f)
                    .setDuration(300)
                    .withEndAction {
                        rootView.removeView(toastView)
                        dequeue()
                    }
            }, duration)
        }.start()
    }
}
