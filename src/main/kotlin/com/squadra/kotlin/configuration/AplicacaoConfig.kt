package com.squadra.kotlin.configuration

import com.squadra.kotlin.adapter.ProdutoAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AplicacaoConfig {

    @Bean
    fun produtoAdapter(): ProdutoAdapter {
        var produto = ProdutoAdapter()
        return produto
    }

}