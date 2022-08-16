package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Categoria;
import com.example.repositories.CategoriaRepository;

@SpringBootApplication
public class CursosmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursosmcApplication.class, args);
	}
     /* salvar as categorias no banco de dados*/
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
	}
	
	

}
