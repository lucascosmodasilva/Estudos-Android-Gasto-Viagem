package com.capacity.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.capacity.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.buttonCalcular.setOnClickListener {
            calculate();
        }
    }

    private fun inputsIsValids(): Boolean {
        if (binding.editDistance.text.toString().toFloatOrNull() === null)
            return false;

        if (binding.editAutonomia.text.toString().toFloatOrNull() === null)
            return false;

        if (binding.editPreco.text.toString().toFloatOrNull() === null)
            return false;

        return true;
    }

    private fun calculate() {
        if (inputsIsValids()) {
            val distancia = binding.editDistance.text.toString().toFloat();
            val autonomia = binding.editAutonomia.text.toString().toFloat();
            val preco = binding.editPreco.text.toString().toFloat();

            var totalValue = (distancia * preco) / autonomia;
            var totalValueSt = "R$ ${"%.2f".format(totalValue)}";

            binding.textValorTotal.text = totalValueSt;
        } else {
            Toast.makeText(this,
                getString(R.string.preencha_os_campos_corretamente), Toast.LENGTH_SHORT).show();
        }
    }
}