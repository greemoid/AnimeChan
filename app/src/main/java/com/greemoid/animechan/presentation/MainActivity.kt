package com.greemoid.animechan.presentation

import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.greemoid.animechan.QuoteApp
import com.greemoid.animechan.R
import com.greemoid.animechan.core.presentation.CommonViewModel

class MainActivity : AppCompatActivity() {

    lateinit var button: CorrectButton
    lateinit var progressBar: CorrectProgressBar
    lateinit var checkBox: CheckBox
    lateinit var imageButton: CorrectImageButton
    lateinit var viewModel: BaseViewModel
    lateinit var textView: CorrectTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button_get_quote)
        progressBar = findViewById(R.id.progressBar)
        checkBox = findViewById(R.id.checkbox_favorite)
        imageButton = findViewById(R.id.button_add_favorite)
        textView = findViewById(R.id.tv_quote)
        viewModel = (application as QuoteApp).viewModel

        linkWith(viewModel)
        viewModel.observe(this) { state ->
            show(state)
        }
    }

    private fun linkWith(viewModel: CommonViewModel) {
        button.setOnClickListener {
            viewModel.getQuote()
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.chooseFavorites(isChecked)
        }

        imageButton.setOnClickListener {
            viewModel.changeQuoteStatus()
        }
    }

    private fun show(state: State) =
        state.show(progressBar, button, textView, imageButton)
}