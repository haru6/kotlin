package com.squadra.kotlin.TO

import java.time.LocalDate

class ProdutoTO(var id: Long? = null,
                var preco: Double = 0.0,
                var nome: String = "",
                var descricao: String = "",
                var dataValidade: String = "",
                var promocional: Boolean = false
)