package br.com.fiap.xcave.challenge.controller;

import br.com.fiap.xcave.challenge.entity.Usuario;
import br.com.fiap.xcave.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> obterTodos(){
        return usuarioRepository.getAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUsuarioById(@PathVariable("id") String usuarioId) {
        return usuarioRepository.getUsuarioById(usuarioId);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") String usuarioId) {
        usuarioRepository.delete(usuarioId);
    }

    @PutMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") String usuarioId, @RequestBody Usuario usuario) {
        usuarioRepository.update(usuarioId,usuario);
    }
}
