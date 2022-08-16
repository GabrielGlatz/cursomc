package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Categoria;
import com.example.domain.Cidade;
import com.example.domain.Cliente;
import com.example.domain.Endereco;
import com.example.domain.Estado;
import com.example.domain.Produto;
import com.example.domain.enums.TipoCliente;
import com.example.repositories.CategoriaRepository;
import com.example.repositories.CidadeRepository;
import com.example.repositories.ClienteRepository;
import com.example.repositories.EnderecoRepository;
import com.example.repositories.EstadoRepository;
import com.example.repositories.ProdutoRepository;

@SpringBootApplication
public class CursosmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "Maria Silva ", "maria@GMAIL.COM", "36378912377", TipoCliente.PESSOAFISICA);
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		/*AQUI EU ADICIONEI OS PRODUTOS NAS CATEGORIAS CORRESPONDENTES, EX: NA INFORMATICA TEM COMPUTADOR, IMPRESSORA E MOUSE*/
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		/*AQUI TA SALVANDO AS LISTAS */
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}
	
	

}
