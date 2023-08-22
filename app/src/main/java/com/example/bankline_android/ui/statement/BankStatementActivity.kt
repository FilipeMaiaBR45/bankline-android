package com.example.bankline_android.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankline_android.R
import com.example.bankline_android.data.State
import com.example.bankline_android.databinding.ActivityBankStatementBinding
import com.example.bankline_android.databinding.ActivityWelcomeBinding
import com.example.bankline_android.domain.Correntista
import com.example.bankline_android.domain.Movimentacao
import com.example.bankline_android.domain.TipoMovimentacao
import com.example.bankline_android.ui.statement.adapter.BankStatementAdapter
import com.google.android.material.snackbar.Snackbar

class BankStatementActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER)
            ?: throw IllegalArgumentException()
    }


    companion object {
        const val EXTRA_ACCOUNT_HOLDER =
            "com.example.bankline_android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val viewModel by viewModels<BankStatementViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBanckStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()

        binding.srlBanckStatement.setOnRefreshListener {
            findBankStatement()
        }

    }

    private fun findBankStatement() {
        viewModel.findBankStatement(accountHolder.id).observe(this) { state ->
            when (state) {
                is State.Error -> {
                    state.message?.let {
                        Snackbar.make(binding.rvBanckStatement, state.message, Snackbar.LENGTH_LONG)
                            .show()
                    }

                    binding.srlBanckStatement.isRefreshing = false
                }

                is State.Success -> {
                    binding.rvBanckStatement.adapter = state.data?.let { BankStatementAdapter(it) }
                    binding.srlBanckStatement.isRefreshing = false
                }

                State.Wait -> binding.srlBanckStatement.isRefreshing = true
            }
        }


    }
}