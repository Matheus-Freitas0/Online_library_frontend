package com.online.library.service.impl;

import com.online.library.domain.Livro;
import com.online.library.dto.LivroDto;
import com.online.library.exception.ResourceNotFoundException;
import com.online.library.mapper.LivroMapper;
import com.online.library.repository.LivroRepository;
import com.online.library.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public LivroDto updateLivro(Long id, LivroDto livroDto) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro com ID " + id + " não encontrado"));

        if (livroDto.getTitulo() != null) livroExistente.setTitulo(livroDto.getTitulo());
        if (livroDto.getAutor() != null) livroExistente.setAutor(livroDto.getAutor());
        if (livroDto.getEditora() != null) livroExistente.setEditora(livroDto.getEditora());
        if (livroDto.getIsbn() != null) livroExistente.setIsbn(livroDto.getIsbn());
        if (livroDto.getAnoPublicacao() != null) livroExistente.setAnoPublicacao(livroDto.getAnoPublicacao());
        if (livroDto.getQuantidadeTotal() != null) livroExistente.setQuantidadeTotal(livroDto.getQuantidadeTotal());
        if (livroDto.getQuantidadeDisponivel() != null) livroExistente.setQuantidadeDisponivel(livroDto.getQuantidadeDisponivel());

        Livro livroAtualizado = livroRepository.save(livroExistente);
        return LivroMapper.toDto(livroAtualizado);
    }

    @Override
    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
