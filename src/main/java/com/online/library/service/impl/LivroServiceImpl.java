package com.online.library.service.impl;

import com.online.library.domain.Livro;
import com.online.library.repository.LivroRepository;
import com.online.library.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private LivroRepository livroRepository;


    @Override
    public Livro getLivroById(Long id) {
        return livroRepository.getReferenceById(id);
    }
}
