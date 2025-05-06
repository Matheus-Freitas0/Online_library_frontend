package com.online.library.service.impl;

import com.online.library.domain.Emprestimo;
import com.online.library.domain.Livro;
import com.online.library.dto.LivroDto;
import com.online.library.repository.EmprestimoRepository;
import com.online.library.repository.LivroRepository;
import com.online.library.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final EmprestimoRepository emprestimoRepository;

    @Override
    public List<Livro> getLivroByTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public Optional<Livro> getLivroById(Long id) {
        return livroRepository.findById(id);
    }

    @Override
    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    @Override
    public Livro createLivro(LivroDto livroDto) {
        Livro livro = Livro.builder()
                .titulo(livroDto.getTitulo())
                .autor(livroDto.getAutor())
                .editora(livroDto.getEditora())
                .isbn(livroDto.getIsbn())
                .anoPublicacao(livroDto.getAnoPublicacao())
                .quantidadeTotal(livroDto.getQuantidadeTotal())
                .quantidadeDisponivel(livroDto.getQuantidadeDisponivel() != null ? livroDto.getQuantidadeDisponivel() : livroDto.getQuantidadeTotal())
                .build();
        return livroRepository.save(livro);
    }

    @Override
    public Livro updateLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
