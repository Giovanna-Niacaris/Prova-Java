package br.com.reformas.api.produto;

public record DadosListagemProduto(
	    Long id,
	    String nome,
	    Double preco,
	    Integer estoque
	) {
	
	public DadosListagemProduto(Produto produto) {
		this(
				produto.getId(),
				produto.getNome(),
				produto.getPreco(),
				produto.getEstoque()
			);
	}
}
	


