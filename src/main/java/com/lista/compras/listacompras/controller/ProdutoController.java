package com.lista.compras.listacompras.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lista.compras.listacompras.model.Produto;
import com.lista.compras.listacompras.services.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/produto", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Produto>> consultarProduto() {
		
		Collection<Produto> produtos = produtoService.consultarProdutos();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/produto", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
		
		Produto produtoCadastrado = produtoService.cadastrarProduto(produto);
		return new ResponseEntity<Produto>(produtoCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/produto/{id}")
	public ResponseEntity<Produto> excluirProduto(@PathVariable Integer id){
		
		Produto produtoEncontrado = produtoService.consultarPorID(id);
		if (produtoEncontrado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		produtoService.excluir(produtoEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
