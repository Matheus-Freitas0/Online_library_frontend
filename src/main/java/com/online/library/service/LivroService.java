package com.online.library.service;

import com.online.library.dto.LivroDto;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    List<LivroDto> getLivroByTitulo (String titulo);

    Optional<LivroDto> getLivroById (Long id);

    List<LivroDto> getAllLivros();

    LivroDto createLivro(LivroDto livroDto);

    LivroDto updateLivro(LivroDto livro);

    void deleteLivro(Long id);
}
