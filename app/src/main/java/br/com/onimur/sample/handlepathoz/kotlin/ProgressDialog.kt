/*
 * Created by Murillo Comino on 18/06/20 20:56
 * Github: github.com/onimur
 * StackOverFlow: pt.stackoverflow.com/users/128573
 * Email: murillo_comino@hotmail.com
 *
 *  Copyright (c) 2020.
 *  Last modified 18/06/20 20:41
 */

package br.com.onimur.sample.handlepathoz.kotlin

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import br.com.comino.sample.handlepathoz.R

class ProgressDialog(context: Context, private val text: String) : Dialog(context) {
    private lateinit var textView: TextView
    private lateinit var textViewLoad: TextView

    var currentLoad: String = ""
        set(value) {
            textViewLoad.text = value
            field = value
        }


    override fun create() {
        val view = View.inflate(context, R.layout.dialog_progressbar, null)
        setContentView(view)
        textView = view.findViewById(R.id.tv_progress_dialog)
        textViewLoad = view.findViewById(R.id.tv_list_load)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        textView.text = text

    }
}