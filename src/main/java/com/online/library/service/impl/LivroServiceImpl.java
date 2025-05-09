package com.online.library.service.impl;

import com.online.library.domain.Livro;
import com.online.library.dto.LivroDto;
import com.online.library.mapper.LivroMapper;
import com.online.library.repository.LivroRepository;
import com.online.library.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
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
    public Optional<LivroDto> getLivroById(Long id) {
        return livroRepository.findById(id).map(LivroMapper::toDto);
    }

    @Override
    public List<LivroDto> getAllLivros() {
        List<Livro> livros = livroRepository.findAll();
        return LivroMapper.toDtoList(livros);
    }

    @Override
    public LivroDto createLivro(LivroDto livroDto) {
        Livro livro = LivroMapper.toEntity(livroDto, new HashSet<>());
        Livro livroEntity = livroRepository.save(livro);
        return LivroMapper.toDto(livroEntity);
    }

    @Override
    public LivroDto updateLivro(LivroDto livroDto) {
        Livro livro = LivroMapper.toEntity(livroDto, new HashSet<>());
        Livro livroEntity = livroRepository.save(livro);
        return LivroMapper.toDto(livroEntity);
    }

    @Override
    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
