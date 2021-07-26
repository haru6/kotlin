package com.squadra.kotlin.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Produto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_produto")
        var id: Long? = null,
        @Column(name = "preco")
        var preco: Double = 0.0,
        @Column(name = "nm_nome")
        var nome: String = "",
        @Column(name = "ds_descricao")
        var descricao: String = "",
        @Column(name = "dh_data_validade")
        var dataValidade: LocalDate = LocalDate.now(),
        @Column(name = "st_promocional")
        var promocional: Boolean = false
)