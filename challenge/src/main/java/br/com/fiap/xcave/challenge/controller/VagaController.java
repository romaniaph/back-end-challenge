package br.com.fiap.xcave.challenge.controller;

import br.com.fiap.xcave.challenge.entity.Vaga;
import br.com.fiap.xcave.challenge.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;

    @PostMapping("/vaga")
    public Vaga salvar(@RequestBody Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    @GetMapping("/vaga")
    public List<Vaga> obterTodos(){
        return vagaRepository.getAll();
    }

    @GetMapping("/vaga/{id}")
    public Vaga getVagaById(@PathVariable("id") String vagaId) {
        return vagaRepository.getVagaById(vagaId);
    }

    @DeleteMapping("/vaga/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") String vagaId) {
        vagaRepository.delete(vagaId);
    }

    @PutMapping("/vaga/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") String vagaId, @RequestBody Vaga vaga) {
        vagaRepository.update(vagaId,vaga);
    }
}