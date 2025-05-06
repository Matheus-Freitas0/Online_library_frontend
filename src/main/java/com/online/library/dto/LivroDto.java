package com.online.library.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LivroDto {
    @NotBlank(message = "Título é obrigatório")
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    @Min(value = 1500, message = "Ano inválido")
    private Integer anoPublicacao;
    @NotNull(message = "Quantidade total é obrigatória")
    @Min(value = 0, message = "Quantidade total não pode ser negativa")
    private Integer quantidadeTotal;
    @Min(value = 0, message = "Quantidade disponível não pode ser negativa")
    private Integer quantidadeDisponivel;

    private Set<Long> emprestimosIds;
}
