package app.kkw.worddictionaryapplication.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.kkw.worddictionaryapplication.R
import com.google.android.material.textfield.TextInputLayout

class AddWordActivity : AppCompatActivity() {
    private val menuItem = listOf("전체", "영어")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_word)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val menu: TextInputLayout = findViewById(R.id.menu)
        val adapterItem = ArrayAdapter(this, R.layout.menu_item, menuItem)
        (menu.editText as? AutoCompleteTextView)?.setAdapter(adapterItem)

        val searchButton: Button = findViewById(R.id.searchButton)

        searchButton.setOnClickListener {
            val inputMethodManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val textField: TextInputLayout = findViewById(R.id.searchField)

            inputMethodManager.hideSoftInputFromWindow(textField.windowToken, 0)

            Log.d("DEBUG", "field result : ${textField.editText?.text}")
        }
    }
}