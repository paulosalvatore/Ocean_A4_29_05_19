package br.com.paulosalvatore.ocean_a4_29_05_19

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_drawer.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeRecebido = intent.getStringExtra("NOME")
        etNome.setText(nomeRecebido)

        btEnviar.setOnClickListener {
            val nome = etNome.text
            val sobrenome = etSobrenome.text

            if (nome.isNotBlank() && sobrenome.isNotBlank()) {
                val nomeSobrenome = "$nome $sobrenome"
                tvNome.text = nomeSobrenome

                val intentResult = Intent()
                intentResult.putExtra("NOME_SOBRENOME", nomeSobrenome)

                setResult(Activity.RESULT_OK, intentResult)
                finish()
            } else {
                if (nome.isBlank()) {
                    etNome.error = "Digite o seu nome"
                }

                if (sobrenome.isBlank()) {
                    etSobrenome.error = "Digite o seu sobrenome"
                }
            }
        }
        btAbrirTela.setOnClickListener {
            val nome = etNome.text
            val sobrenome = etSobrenome.text

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("NOME_SOBRENOME", "$nome $sobrenome")
            startActivity(intent)
        }
    }
}
