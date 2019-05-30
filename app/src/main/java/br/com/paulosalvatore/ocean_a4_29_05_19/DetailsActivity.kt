package br.com.paulosalvatore.ocean_a4_29_05_19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val nomeRecebido = intent.getStringExtra("NOME_SOBRENOME")
        tvNome.text = nomeRecebido
    }
}
