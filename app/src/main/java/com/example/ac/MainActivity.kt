package com.example.ac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showMainScreen()
    }

    private fun showMainScreen() {
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            showQuizScreen()
        }
    }

    private fun showQuizScreen() {
        setContentView(R.layout.quiz)
        val rg = findViewById<RadioGroup>(R.id.rgColors)
        findViewById<Button>(R.id.btnNext).setOnClickListener {
            when (rg.checkedRadioButtonId) {
                R.id.rbBlue  -> showCapitao()
                R.id.rbRed   -> showHomemDeFerro()
                R.id.rbGreen -> showHulk()
                else -> Toast.makeText(this, "Escolha uma cor", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showCapitao() {
        setContentView(R.layout.capitao)
        // voltar ao início
        findViewById<ImageButton>(R.id.btnCapitao).setOnClickListener {
            showMainScreen()
        }
        // compartilhar
        findViewById<Button>(R.id.btnShare).setOnClickListener {
            val share = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Eu sou o Capitão América!")
            }
            startActivity(Intent.createChooser(share, "Compartilhar seu herói"))
        }
    }

    private fun showHomemDeFerro() {
        setContentView(R.layout.homemdeferro)
        findViewById<ImageButton>(R.id.btnHomemDeFerro).setOnClickListener {
            showMainScreen()
        }
        findViewById<Button>(R.id.btnShare).setOnClickListener {
            val share = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Eu sou o Homem de Ferro!")
            }
            startActivity(Intent.createChooser(share, "Compartilhar seu herói"))
        }
    }

    private fun showHulk() {
        setContentView(R.layout.hulk)
        findViewById<ImageButton>(R.id.btnHulk).setOnClickListener {
            showMainScreen()
        }
        findViewById<Button>(R.id.btnShare).setOnClickListener {
            val share = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Eu sou um herói de super força como o Hulk!")
            }
            startActivity(Intent.createChooser(share, "Compartilhar seu herói"))
        }
    }



}

