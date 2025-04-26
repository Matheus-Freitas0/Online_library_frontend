package com.online.library.domain;

import com.online.library.enums.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import static com.online.library.enums.TipoUsuario.LEITOR;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "usuario")
public class Usuario extends Domain {

    @Column(nullable = false)
    @Size(min = 1, message = "Nome deve possuir pelo menos um caracter")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Column(nullable = false)
    @Email(message = "Email invalido")
    @NotNull(message = "Email não pode ser nulo")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Senha não pode ser nula")
    @Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")
    private String senha;

    @Column(nullable = false)
    @NotNull(message = "Não pode ser nula")
    private TipoUsuario tipo = LEITOR;
}
