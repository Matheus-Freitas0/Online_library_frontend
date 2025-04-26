package com.online.library.domain;

import com.online.library.enums.StatusEmprestimo;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.online.library.enums.StatusEmprestimo.EM_ANDAMENTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "emprestimo")
public class Emprestimo extends Domain {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "Usuario não pode ser nulo")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "emprestimo_livro",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    @NotNull(message = "A lista de livros não pode estar vazia")
    private Set<Livro> livros = new HashSet<>();

    @FutureOrPresent(message = "A data de devolução não pode ser no passado")
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Column(name = "data_devolvido")
    private LocalDate dataDevolvido;

    @Column(nullable = false)
    @NotNull(message = "O status do empréstimo não pode ser nulo")
    private StatusEmprestimo status = EM_ANDAMENTO;

}
