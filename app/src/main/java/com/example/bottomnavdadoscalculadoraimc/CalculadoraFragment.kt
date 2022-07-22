package com.example.bottomnavdadoscalculadoraimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bottomnavdadoscalculadoraimc.databinding.FragmentCalculadoraBinding


class CalculadoraFragment : Fragment() {
    private var _binding: FragmentCalculadoraBinding? = null
    private val binding get() = _binding!!
    private var n1 = 0
    private var n2 = 0
    private var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculadoraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPunto.setOnClickListener {
            if (!binding.tvPantalla.text.toString().contains('.'))
                binding.tvPantalla.text = binding.tvPantalla.text.toString().plus(".")
        }

        binding.btnClear.setOnClickListener {
            binding.tvPantalla.text = "0"
            n1 = 0
            n2 = 0
            op = ""
        }
        binding.btnIgual.setOnClickListener {
            if (op != "")
                n2 = binding.tvPantalla.text.toString().toInt()

            binding.tvPantalla.text = when (op){
                "/" -> (n1/n2).toString()
                "*" -> (n1*n2).toString()
                "-" -> (n1-n2).toString()
                "+" -> (n1+n2).toString()
                else -> "Error"
            }
            op = ""

        }
        binding.btnCero.setOnClickListener { onClickZero() }
        binding.btnUno.setOnClickListener { onClickNumber("1") }
        binding.btnDos.setOnClickListener { onClickNumber("2") }
        binding.btnTres.setOnClickListener { onClickNumber("3") }
        binding.btnCuatro.setOnClickListener { onClickNumber("4") }
        binding.btnCinco.setOnClickListener { onClickNumber("5") }
        binding.btnSeis.setOnClickListener { onClickNumber("6") }
        binding.btnSiete.setOnClickListener { onClickNumber("7") }
        binding.btnOcho.setOnClickListener { onClickNumber("8") }
        binding.btnNueve.setOnClickListener { onClickNumber("9") }


        binding.btnSumar.setOnClickListener { onClickOp()
            n1 = binding.tvPantalla.text.toString().toInt()
            op = "+"
            binding.tvPantalla.text = "0"}
        binding.btnRestar.setOnClickListener { onClickOp()
            n1 = binding.tvPantalla.text.toString().toInt()
            op = "-"
            binding.tvPantalla.text = "0"}
        binding.btnMultiplicar.setOnClickListener { onClickOp()
            n1 = binding.tvPantalla.text.toString().toInt()
            op = "*"
            binding.tvPantalla.text = "0"}
        binding.btnDividir.setOnClickListener { onClickOp()
            n1 = binding.tvPantalla.text.toString().toInt()
            op = "/"
            binding.tvPantalla.text = "0"}

    }
    fun onClickZero(){
       if ( binding.tvPantalla.text.toString() != "0") {
           binding.tvPantalla.text = binding.tvPantalla.text.toString().plus("0")
       }
    }

    fun onClickNumber(n:String){
        if ( binding.tvPantalla.text.toString() == "0") {
            binding.tvPantalla.text = ""
        }
        binding.tvPantalla.text = binding.tvPantalla.text.toString().plus(n)
    }

    fun onClickOp(){
        if (view is Button){
            n1 = binding.tvPantalla.text.toString().toInt()
            binding.tvPantalla.text = "0"
        }
    }
}