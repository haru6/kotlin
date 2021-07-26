package com.squadra.kotlin.service

import com.squadra.kotlin.configuration.MessageError
import com.squadra.kotlin.exceptions.BusinessException
import com.squadra.kotlin.model.Produto
import com.squadra.kotlin.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Period
import java.util.*

@Service
class ProdutoService {

    @Autowired
    lateinit var produtoRepository: ProdutoRepository

    fun listarProdutos(): List<Produto> = produtoRepository.findAll()

    fun obterProduto(id: Long): Produto {
        var produto = produtoExiste(id)
        return produto
    }

    private fun validade(produto: Produto): Produto {
        val dataAtual: LocalDate = LocalDate.now()
        val dias: Period = Period.between(dataAtual, produto.dataValidade)
        produto.promocional = (produto.dataValidade >= dataAtual) && ((dias.days < 7) && (dias.months == 0) )
        return produto
    }

    fun cadastrarProduto(produto: Produto) {
        val produtoAtualizado = validade(produto)
        produtoRepository.save(produtoAtualizado)
    }

    fun excluirProduto(id: Long) = produtoRepository.deleteById(id)

    fun alterarProduto(id: Long, produto: Produto) {
        produtoExiste(id)
        produto.id = id
        produtoRepository.save(produto)
    }

    fun produtoExiste(id: Long): Produto = (produtoRepository.findById(id).orElseThrow {
        throw BusinessException(MessageError.PRODUTO_NAO_ENCONTRADO)
    })


}