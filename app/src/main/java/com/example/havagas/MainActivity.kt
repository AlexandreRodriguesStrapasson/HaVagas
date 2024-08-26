package com.example.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import android.widget.Toast
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

        amb.salvarBt.setOnClickListener {
            val nomeCompleto =          amb.nomeTv.text.toString()
            val email =                 amb.emailEt.text.toString()
            val telefone =              amb.telefoneEt.text.toString()
            val checkBoxSelecionada =   if (amb.telefoneCb.isChecked) "sim" else "não"
            val emailCheckBox =         if(amb.emailCb.isChecked) "sim" else "não"
            val celular =               amb.telefoneETLl.text.toString()
            val sexo =                  amb.sexoEt.text.toString()
            val formacao =              amb.formacaoSp.selectedItem.toString()
            val anoFormatura =          amb.anoFormaturaEt.text.toString()
            val graduacao =             amb.anoGraduacaoEt.text.toString()
            val instituicao =           amb.instituicaoEt.text.toString()
            val monografia =            amb.monografiaEt.text.toString()
            val orientador =            amb.orientadorEt.text.toString()
            val radioSelecionado =      if (amb.residencialRb.isChecked) "Residencial" else "Comercial"


            var mensagem = "Nome Completo: $nomeCompleto \n" +
                    "E-mail: $email \n" +
                    "Telefone: $telefone \n" +
                    "Tipo de Telefone: $radioSelecionado \n" +
                    "Celuar: $checkBoxSelecionada \n" +
                    "Deseja receber E-mails: $emailCheckBox \n" +
                    "Sexo: $sexo \n" +
                    "Formacao: $formacao \n"

            if (amb.telefoneCb.isChecked) mensagem += "celular: $celular \n"
            when (formacao){
                "Fundamental",  "Médio"       -> mensagem += "$anoFormatura \n"
                "Graduação", "Especialização" -> mensagem +=  "Ano Graduação: $graduacao \n" +
                                                        "Insituicao: $instituicao"
                "Mestrado", "Doutorado"       -> mensagem += "Ano Graduação: $graduacao \n" +
                                                        "Insituicao: $instituicao \n" +
                                                        "Titulo de monografia: $monografia \n" +
                                                        "Orientador: $orientador \n"
            }

            Toast.makeText(
            this@MainActivity,
                    mensagem,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}