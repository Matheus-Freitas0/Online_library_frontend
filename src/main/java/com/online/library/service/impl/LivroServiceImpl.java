package com.online.library.service.impl;

import com.online.library.domain.Livro;
import com.online.library.dto.LivroDto;
import com.online.library.mapper.LivroMapper;
import com.online.library.repository.LivroRepository;
import com.online.library.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Override
    public List<LivroDto> getLivroByTitulo(String titulo) {
        List<Livro> livros = livroRepository.findByTituloContainingIgnoreCase(titulo);
        return LivroMapper.toDtoList(livros);
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
