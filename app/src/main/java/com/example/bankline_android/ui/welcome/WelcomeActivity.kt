package com.example.bankline_android.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bankline_android.R
import com.example.bankline_android.databinding.ActivityWelcomeBinding
import com.example.bankline_android.domain.Correntista
import com.example.bankline_android.ui.statement.BankStatementActivity

class WelcomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.btContinue.setOnClickListener {

            try {
                val accountHolderId = binding.edAccountHolderId.text.toString().toInt()
                val accountHolder = Correntista(accountHolderId)
                val intent = Intent(this, BankStatementActivity::class.java).apply {
                    putExtra(BankStatementActivity.EXTRA_ACCOUNT_HOLDER, accountHolder)
                }
                startActivity(intent)
                binding.edAccountHolderIdLayout.error = null

            } catch (e: NumberFormatException) {
                binding.edAccountHolderIdLayout.error = "Digite um ID"
            }
        }


    }
}