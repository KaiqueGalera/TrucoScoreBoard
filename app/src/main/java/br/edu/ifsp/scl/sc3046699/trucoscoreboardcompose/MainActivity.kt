package br.edu.ifsp.scl.sc3046699.trucoscoreboardcompose

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var pontosA = 0
    private var pontosB = 0

    private lateinit var textPontosA: TextView
    private lateinit var textPontosB: TextView
    private lateinit var textMensagem: TextView

    private lateinit var buttonMais1A: Button
    private lateinit var buttonMais3A: Button
    private lateinit var buttonMais1B: Button
    private lateinit var buttonMais3B: Button
    private lateinit var buttonReiniciar: Button

    private fun jogoFinalizado(): Boolean {
        return pontosA >= 12 || pontosB >= 12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        textPontosA = findViewById(R.id.textPontosA)
        textPontosB = findViewById(R.id.textPontosB)
        textMensagem = findViewById(R.id.textMensagem)

        buttonMais1A = findViewById(R.id.buttonMais1A)
        buttonMais3A = findViewById(R.id.buttonMais3A)
        buttonMais1B = findViewById(R.id.buttonMais1B)
        buttonMais3B = findViewById(R.id.buttonMais3B)

        buttonReiniciar = findViewById(R.id.buttonReiniciar)

        configurarBotoes()

    }
    private fun atualizarTela() {

        textPontosA.text = pontosA.toString()
        textPontosB.text = pontosB.toString()

        textMensagem.text = when {
            pontosA >= 12 -> "Equipe A venceu!"
            pontosB >= 12 -> "Equipe B venceu!"
            pontosA == 11 -> "Equipe A entrou na mão de 11!"
            pontosB == 11 -> "Equipe B entrou na mão de 11!"
            else -> ""
        }

        if (jogoFinalizado()) {
            desabilitarBotoes()
        }
    }

    private fun desabilitarBotoes() {
        buttonMais1A.isEnabled = false
        buttonMais3A.isEnabled = false
        buttonMais1B.isEnabled = false
        buttonMais3B.isEnabled = false
    }

    private fun habilitarBotoes() {
        buttonMais1A.isEnabled = true
        buttonMais3A.isEnabled = true
        buttonMais1B.isEnabled = true
        buttonMais3B.isEnabled = true
    }

    private fun configurarBotoes() {

        buttonMais1A.setOnClickListener {
            if (!jogoFinalizado()) {
                pontosA = minOf(pontosA + 1, 12)
                atualizarTela()
            }
        }

        buttonMais3A.setOnClickListener {
            if (!jogoFinalizado()) {
                pontosA = minOf(pontosA + 3, 12)
                atualizarTela()
            }
        }

        buttonMais1B.setOnClickListener {
            if (!jogoFinalizado()) {
                pontosB = minOf(pontosB + 1, 12)
                atualizarTela()
            }
        }

        buttonMais3B.setOnClickListener {
            if (!jogoFinalizado()) {
                pontosB = minOf(pontosB + 3, 12)
                atualizarTela()
            }
        }

        buttonReiniciar.setOnClickListener {
            pontosA = 0
            pontosB = 0

            habilitarBotoes()
            atualizarTela()
        }
    }
}