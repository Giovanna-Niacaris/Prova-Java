package br.com.reformas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import br.com.reformas.api.produto.DadosCadastroProduto;
import br.com.reformas.api.produto.DadosListagemProduto;
import br.com.reformas.api.produto.Produto;
import br.com.reformas.api.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados) {
		System.out.println(dados);
		repository.save(new Produto(dados));
	}
	public record DadosAtualizarProduto(
		    @NotNull Long id,
		    String nome,
		    Double preco,
		    Integer estoque
		) {}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarProduto dados) {
		Produto produto = new Produto();
		produto = repository.getReferenceById(dados.id());
		produto.atualizarInformacoes(dados);
	}
	
	@GetMapping
	public Page<DadosListagemProduto> listar(
			@PageableDefault(size=3, sort={"estoque"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemProduto::new);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable long id) {
		repository.deleteById(id);
	}
	

}










