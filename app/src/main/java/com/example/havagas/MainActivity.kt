package com.example.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        val telefoneCb = amb.telefoneCb
        val telefoneLl = amb.telefoneLl
        val anoFormatura = amb.anoFormaturaEt
        val anoConclusao = amb.anoGraduacaoEt
        val instituicao = amb.instituicaoEt
        val orientador = amb.orientadorEt
        val monografia = amb.monografiaEt

        telefoneCb.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) {
                telefoneLl.isVisible = true
            } else {
                telefoneLl.isVisible = false
            }
        }

        amb.formacaoSp.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val formacao =(view as TextView).text.toString()
                if (formacao == "Médio"){

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }
        }



        amb.formacaoSp.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val formacao = (view as TextView).text.toString()

                when (formacao){
                    "Fundamental" -> {
                        anoFormatura.isVisible = true
                        anoConclusao.isVisible = false
                        instituicao.isVisible = false
                        monografia.isVisible = false
                        orientador.isVisible = false
                    }
                    "Médio" -> {
                        anoFormatura.isVisible = true
                        anoConclusao.isVisible = false
                        instituicao.isVisible = false
                        monografia.isVisible = false
                        orientador.isVisible = false
                    }
                    "Graduação", "Especialização" -> {
                        anoFormatura.isVisible = false
                        anoConclusao.isVisible = true
                        instituicao.isVisible = true
                        monografia.isVisible = false
                        orientador.isVisible = false
                    }
                    "Mestrado", "Doutorado" -> {
                        anoFormatura.isVisible = false
                        anoConclusao.isVisible = true
                        instituicao.isVisible = true
                        monografia.isVisible = true
                        orientador.isVisible = true
                    }

                    else -> {
                        anoFormatura.isVisible = false
                        anoConclusao.isVisible = false
                        instituicao.isVisible = false
                        monografia.isVisible = false
                        orientador.isVisible = false
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }
        }

        amb.limparBt.setOnClickListener {
            amb.nomeEt.text.clear()
            amb.emailEt.text.clear()
            amb.telefoneCb.isChecked = false
            amb.emailCb.isChecked = false
            amb.telefoneEt.text.clear()
            amb.telefoneETLl.text.clear()
            amb.sexoEt.text.clear()
            amb.formacaoSp.setSelection(0)
            amb.anoFormaturaEt.text.clear()
            amb.anoGraduacaoEt.text.clear()
            amb.monografiaEt.text.clear()
            amb.orientadorEt.text.clear()
            amb.campoInteresseEt.text.clear()
        }
    }
}