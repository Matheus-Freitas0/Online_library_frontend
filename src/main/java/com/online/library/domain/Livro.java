    package com.online.library.domain;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.ManyToMany;
    import jakarta.persistence.Table;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import lombok.*;

    import java.util.Set;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    @Table(name = "livro")
    @Entity
    public class Livro extends Domain {

        @Column(nullable = false)
        @Size(min = 1, message = "O titulo deve ter pelo menos 1 caracter")
        private String titulo;

        private String autor;

        private String editora;

        private String isbn;

        @Min(value = 1500, message = "Deve ter um ano de publicação valido")
        @Column(name = "ano_publicacao")
        private Integer anoPublicacao;

        @Column(name = "quantidade_total", nullable = false)
        @NotNull(message = "Quantidade total não pode ser invalida")
        @Min(value = 0, message = "Quatidade total não pode ser negativa")
        private Integer quantidadeTotal;

        @Min(value = 0, message = "Quatidade disponível não pode ser negativa")
        @Column(name = "quantidade_disponivel")
        private Integer quantidadeDisponivel;

        @ManyToMany(mappedBy = "livros")
        private Set<Emprestimo> emprestimos;
    }
