package com.squadra.kotlin.controller

import com.squadra.kotlin.adapter.ProdutoAdapter
import com.squadra.kotlin.TO.ProdutoTO
import com.squadra.kotlin.model.Produto
import com.squadra.kotlin.service.ProdutoService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController()
@RequestMapping("/api/v1/produto")
class ProdutoController {

    @Autowired
    lateinit var produtoService: ProdutoService

    @Autowired
    lateinit var produtoAdapter: ProdutoAdapter

    @GetMapping()
    @ApiOperation("retorna uma lista de produtos")
    fun listarTodos(): ResponseEntity<List<ProdutoTO>>{
        return ResponseEntity.ok(produtoAdapter.listaProdutosParaTO(produtoService.listarProdutos()))
    }

    @GetMapping("/{id}")
    @ApiOperation("retorna um produto")
    fun obter(@PathVariable id: Long): ResponseEntity<ProdutoTO> {
        return ResponseEntity.ok(produtoAdapter.produtoParaTO(produtoService.obterProduto(id)))
    }

    @PostMapping()
    @ApiOperation("salva um produto")
    fun salvar(@RequestBody produto: Produto): ResponseEntity<Produto>{
        produtoService.cadastrarProduto(produto)
        var uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("/{id}")
    @ApiOperation("altera um produto")
    fun alterar(@PathVariable id: Long, @RequestBody produto: Produto): ResponseEntity<Produto> {
        produtoService.alterarProduto(id, produto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    @ApiOperation("deleta um produto")
    fun deletar(@PathVariable id: Long): ResponseEntity<Produto>{
        produtoService.excluirProduto(id)
        return ResponseEntity.noContent().build()
    }

}