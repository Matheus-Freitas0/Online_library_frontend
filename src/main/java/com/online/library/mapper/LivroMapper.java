package com.online.library.mapper;

import com.online.library.domain.Emprestimo;
import com.online.library.domain.Livro;
import com.online.library.dto.LivroDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LivroMapper {

    public static LivroDto toDto(Livro livro) {
        if (livro == null) return null;

        return LivroDto.builder()
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .editora(livro.getEditora())
                .isbn(livro.getIsbn())
                .anoPublicacao(livro.getAnoPublicacao())
                .quantidadeTotal(livro.getQuantidadeTotal())
                .quantidadeDisponivel(livro.getQuantidadeDisponivel())
                .emprestimosIds(mapEmprestimosIds(livro.getEmprestimos()))
                .build();
    }

    private static Set<Long> mapEmprestimosIds(Set<Emprestimo> emprestimos) {
        if (emprestimos == null) return null;

        return emprestimos.stream()
                .map(Emprestimo::getId)
                .collect(Collectors.toSet());
    }

    private static Livro toEntity(LivroDto livroDto, Set<Emprestimo> emprestimos) {
        return Livro.builder()
                .titulo(livroDto.getTitulo())
                .autor(livroDto.getAutor())
                .editora(livroDto.getEditora())
                .isbn(livroDto.getIsbn())
                .anoPublicacao(livroDto.getAnoPublicacao())
                .quantidadeTotal(livroDto.getQuantidadeTotal())
                .quantidadeDisponivel(livroDto.getQuantidadeDisponivel())
                .emprestimos(emprestimos)
                .build();
    }

    public static List<LivroDto> toDtoList(List<Livro> livros) {
        if (livros == null) return null;

        return livros.stream()
                .map(LivroMapper::toDto)
                .collect(Collectors.toList());
    }
}
