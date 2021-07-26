package com.squadra.kotlin.repository

import com.squadra.kotlin.model.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository: JpaRepository<Produto, Long> {
}