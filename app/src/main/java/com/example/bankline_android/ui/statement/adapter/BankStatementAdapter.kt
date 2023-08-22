package com.example.bankline_android.ui.statement.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankline_android.R
import com.example.bankline_android.databinding.BankStatementItemBinding
import com.example.bankline_android.domain.Movimentacao
import com.example.bankline_android.domain.TipoMovimentacao

class BankStatementAdapter(private val dataSet: List<Movimentacao>) :
    RecyclerView.Adapter<BankStatementAdapter.ViewHolder>() {

    class ViewHolder(private val binding: BankStatementItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movimentacao) = with(binding) {
            tvDescription.text = item.descricao
            textValue.text = item.valor.toString()
            textDateTime.text = item.dataHora
            val typeIcon =
                if (TipoMovimentacao.RECEITA == item.tipo) R.drawable.ic_money_in else R.drawable.ic_money_out

            imageView.setImageResource(typeIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            BankStatementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size


}