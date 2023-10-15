package br.com.reformas.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        @NotBlank String nome,
        @NotNull Double preco,
        @NotNull Integer estoque
) {
}
