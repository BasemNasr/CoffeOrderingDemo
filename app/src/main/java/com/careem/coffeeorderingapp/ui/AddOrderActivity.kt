package com.careem.coffeeorderingapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.careem.coffeeorderingapp.R
import com.careem.coffeeorderingapp.data.Coffe
import com.careem.coffeeorderingapp.data.CoffeSize
import com.careem.coffeeorderingapp.data.CoffeType
import com.careem.coffeeorderingapp.data.OrderRequest
import com.careem.coffeeorderingapp.data.Orders.orders
import com.careem.coffeeorderingapp.databinding.ActivityAddOrderBinding

class AddOrderActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddOrderBinding
    val clientName by lazy { binding.name.text.toString() }
    val order by lazy {
        OrderRequest(
            clientName,
            selectedCoffe.coffe.id,
            selectedCoffe.coffeSize.value
        )
    }
    private lateinit var selectedCoffe: Coffe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedCoffe = Coffe(CoffeType.CAPPUCCINO, CoffeSize.SMALL)
        handleUIChanges()

    }

    private fun handleUIChanges() {
        updateUiElements()
        binding.submit.setOnClickListener { submitOrder() }
        binding.typeCappuccino.setOnClickListener {
            selectedCoffe.updateCoffeType(CoffeType.CAPPUCCINO)
            updateUiElements()
        }

        binding.typeEspresso.setOnClickListener {
            selectedCoffe.updateCoffeType(CoffeType.ESPRESSO)
            updateUiElements()
        }

        binding.typeRegular.setOnClickListener {
            selectedCoffe.updateCoffeType(CoffeType.REGULAR)
            updateUiElements()
        }

        binding.sizeSmall.setOnClickListener {
            selectedCoffe.updateCoffeSize(CoffeSize.SMALL)
            updateUiElements()
        }

        binding.sizeMedium.setOnClickListener {
            selectedCoffe.updateCoffeSize(CoffeSize.MEDIUM)
            updateUiElements()
        }

        binding.sizeLarge.setOnClickListener {
            selectedCoffe.updateCoffeSize(CoffeSize.LARGE)
            updateUiElements()
        }
    }

    private fun updateUiElements() {
        when (selectedCoffe.coffe) {
            CoffeType.CAPPUCCINO -> {
                binding.typeCappuccino.isChecked = true
                binding.typeEspresso.isChecked = false
                binding.typeRegular.isChecked = false
            }
            CoffeType.ESPRESSO -> {
                binding.typeCappuccino.isChecked = false
                binding.typeEspresso.isChecked = true
                binding.typeRegular.isChecked = false
            }
            CoffeType.REGULAR -> {
                binding.typeCappuccino.isChecked = false
                binding.typeEspresso.isChecked = false
                binding.typeRegular.isChecked = true
            }
        }
        when (selectedCoffe.coffeSize) {
            CoffeSize.SMALL -> {
                binding.sizeSmall.isChecked = true
                binding.sizeMedium.isChecked = false
                binding.sizeLarge.isChecked = false
            }
            CoffeSize.MEDIUM -> {
                binding.sizeSmall.isChecked = false
                binding.sizeMedium.isChecked = true
                binding.sizeLarge.isChecked = false
            }
            CoffeSize.LARGE -> {
                binding.sizeSmall.isChecked = false
                binding.sizeMedium.isChecked = false
                binding.sizeLarge.isChecked = true
            }
        }
        binding.price.text = getString(R.string.price, selectedCoffe.calculateTotalPrice())

    }
    private fun submitOrder() {
        println("order submitted: $order")
        orders.add(order)
        finish()
    }
}
