package br.com.fiap.xcave.challenge.controller;

import br.com.fiap.xcave.challenge.entity.Usuario;
import br.com.fiap.xcave.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/login/{email}/{senha}")
    public Usuario getUsuarioByLogin(@PathVariable("email") String email, @PathVariable("senha") String senha) {
        return usuarioRepository.getUsuarioByLogin(email,senha);
    }

    @DeleteMapping("/usuario/{id}")
    public String deletar(@PathVariable("id") String usuarioId) {
        return usuarioRepository.delete(usuarioId);
    }

    @PutMapping("/usuario/{id}")
    public String atualizar(@PathVariable("id") String usuarioId, @RequestBody Usuario usuario) {
        return usuarioRepository.update(usuarioId,usuario);
    }
}