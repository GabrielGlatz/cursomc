package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Categoria;
import com.example.domain.Produto;
import com.example.repositories.CategoriaRepository;
import com.example.repositories.ProdutoRepository;

@SpringBootApplication
public class CursosmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursosmcApplication.class, args);
	}
     /* salvar as categorias no banco de dados*/
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora ", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);	
		
		
		/*AQUI EU ADICIONEI OS PRODUTOS NAS CATEGORIAS CORRESPONDENTES, EX: NA INFORMATICA TEM COMPUTADOR, IMPRESSORA E MOUSE*/
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		/*AQUI TA SALVANDO A LISTA DE CATEGORIA */
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		produtorepository.saveAll(Arrays.asList(p1, p2, p3));
	}
	
	

}
