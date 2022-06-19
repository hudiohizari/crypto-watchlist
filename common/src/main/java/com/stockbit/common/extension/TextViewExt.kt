package com.stockbit.common.extension

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat

fun TextView.setupClickableText(
    originText: String,
    clickableTexts: Array<String>,
    onClicks: Array<() -> Unit>,
    highlightedColors: Array<Int>?
) {
    val ss = SpannableString(originText)
    for (i in clickableTexts.indices) {
        val clickableText = clickableTexts[i]
        val onClick = onClicks[i]
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                onClick()
            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                highlightedColors?.get(i)?.let { ds.color = ContextCompat.getColor(context, it) }
            }
        }
        val span = originText.indexOf(clickableText)
        ss.setSpan(
            clickableSpan,
            span,
            span + clickableText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        ss.setSpan(
            clickableSpan,
            span,
            span + clickableText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    setText(ss, TextView.BufferType.SPANNABLE)
    movementMethod = LinkMovementMethod.getInstance()
    isClickable = true
}