package com.github.saldisobi.rxsample.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.saldisobi.rxsample.app.databinding.ActivityMainBinding
import com.github.saldisobi.rxsample.library.FactorialCalculator
import com.github.saldisobi.rxsample.library.android.NotificationUtil

class MainActivity : AppCompatActivity() {

    private val notificationUtil: NotificationUtil by lazy { NotificationUtil(this) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCompute.setOnClickListener {
            val input = binding.editTextFactorial.text.toString().toInt()
            val result = FactorialCalculator.computeFactorial(input).toString()

            binding.textResult.text = result
            binding.textResult.visibility = View.VISIBLE

            notificationUtil.showNotification(
                context = this,
                title = getString(R.string.notification_title),
                message = result
            )
        }
    }
}
