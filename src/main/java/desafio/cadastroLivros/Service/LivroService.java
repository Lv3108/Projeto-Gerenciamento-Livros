package desafio.cadastroLivros.Service;


import desafio.cadastroLivros.DTO.LivroDTO;
import desafio.cadastroLivros.Exceptions.BusinessException;
import desafio.cadastroLivros.Exceptions.ResourceNotFoundException;
import desafio.cadastroLivros.Model.Livro;
import desafio.cadastroLivros.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro save( LivroDTO livroDTO) {
        if(livroDTO.getTitulo() == null || livroDTO.getAutor() == null) {
            throw new BusinessException("Campo de título e autor são obrigatórios");
        } else {
            Livro livro = new Livro();

            livro.setTitulo(livroDTO.getTitulo());
            livro.setAutor(livroDTO.getAutor());
            livro.setAnoPublicado(livroDTO.getAnoPublicado());
            livro.setIsbn(livroDTO.getIsbn());
            livro.setDisponivel(livroDTO.isDisponivel());
            return repository.save(livro);
        }
    }
    public void deleteAll() {
        repository.deleteAll();
    }
    public void deleteById(Long id) {

        Livro livro = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro não existe, por favor tente novamnete mais tarde!"));
        if(livro.getId() != null) {
            repository.deleteById(id);
        }

    }
    public List<Livro> findAll() {
        return repository.findAll();
    }
    public Livro findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Livro não existe, por favor tente novamente!"));
    }

    public Livro atualizar(Long id, LivroDTO livroAtualizado) {
        Livro livro = repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Este livro não existe tente novamente!"));

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setAnoPublicado(livroAtualizado.getAnoPublicado());
        livro.setIsbn(livroAtualizado.getIsbn());
        livro.setDisponivel(livroAtualizado.isDisponivel());

        return repository.save(livro);
    }
    public List<Livro> findByDisponivelTrue() {
        return repository.findByDisponivelTrue();
    }
    public Livro marcarComoDisponivel(Long id) {
        Livro livro = repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Livro não existe, por favor tente novamente!"));

        livro.setDisponivel(true);

        return repository.save(livro);
    }
    public Livro marcarComoIndisponivel(Long id) {
       Livro livro = repository.findById(id)
                       .orElseThrow(() ->
                               new ResourceNotFoundException("Livro não existe, por favor tente novamente!"));

        livro.setDisponivel(false);

        return repository.save(livro);
    }


}
