package com.squadra.kotlin.adapter

interface Mapper<T, U> {
    fun map(t:T): U

    fun listaMap(t:List<T>): List<U>
}