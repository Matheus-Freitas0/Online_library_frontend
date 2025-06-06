package com.online.library.controller;

import com.online.library.dto.LivroDto;
import com.online.library.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("livraria/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/titulo/{titulo}")
    public List<LivroDto> getLivroByTitulo(@PathVariable String titulo) {
        return livroService.getLivroByTitulo(titulo);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public Optional<LivroDto> getLivroById(@PathVariable Long id) {
        return livroService.getLivroById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<LivroDto> getAllLivros() {
        return livroService.getAllLivros();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteLivroById(@PathVariable Long id) {
        livroService.deleteLivro(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public LivroDto createLivro(@RequestBody @Valid LivroDto livroDto) {
        return livroService.createLivro(livroDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update/{id}")
    public LivroDto updateLivro(@PathVariable Long id, @RequestBody @Valid LivroDto livroDto) {
        return livroService.updateLivro(id, livroDto);
    }


}
