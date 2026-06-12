package desafio.cadastroLivros.Controller;


import desafio.cadastroLivros.DTO.LivroDTO;
import desafio.cadastroLivros.Exceptions.BusinessException;
import desafio.cadastroLivros.Model.Livro;
import desafio.cadastroLivros.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping("/livro")
    public Livro save(@RequestBody LivroDTO livroDTO) {
       return service.save(livroDTO);
    }
    @DeleteMapping("/livro")
    public void deleteAll() {
        service.deleteAll();
    }
    @DeleteMapping("/livro/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
    @GetMapping("/livro")
    public List<Livro> findAll() {
        return service.findAll();
    }
    @GetMapping("/livro/{id}")
    public Livro findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @GetMapping("/livro/{id}/buscarPorDisponivel")
    public List<Livro> findByDisponivelTrue() {
        return service.findByDisponivelTrue();
    }
    @PutMapping("/livro/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody LivroDTO livroAtualizado) {
        return service.atualizar(id, livroAtualizado);
    }
    @PatchMapping("/livro/{id}/disponivel")
    public Livro marcaComoDisponivel(@PathVariable Long id) {
        return service.marcarComoDisponivel(id);
    }
    @PatchMapping("/livro/{id}/indisponivel")
    public Livro marcarComoIndisponivel(@PathVariable Long id) {
            return service.marcarComoIndisponivel(id);
    }


}
