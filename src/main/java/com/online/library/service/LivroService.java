package com.online.library.service;

import com.online.library.domain.Livro;
import com.online.library.dto.LivroDto;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    List<Livro> getLivroByTitulo (String titulo);

    Optional<Livro> getLivroById (Long id);

    List<Livro> getAllLivros();

    Livro createLivro(LivroDto livroDto);

    Livro updateLivro(Livro livro);

    void deleteLivro(Long id);
}
