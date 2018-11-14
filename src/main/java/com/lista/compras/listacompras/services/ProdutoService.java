package com.lista.compras.listacompras.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lista.compras.listacompras.model.Produto;
import com.lista.compras.listacompras.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public Collection<Produto> consultarProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto cadastrarProduto(Produto produto) {
		if (produto == null) {
			System.out.println("Nao pode ser null");
		}
		return produtoRepository.save(produto);
		
	}
	
	public void excluir(Produto produto) {
		Produto produtoEncontrado = consultarPorID(produto.getId());
		
		
		
		produtoRepository.delete(produtoEncontrado);
	}
	
	public Produto consultarPorID(Integer id) {
		return produtoRepository.findById(id).get();
		
	}
}
