package desafio.cadastroLivros.Repository;


import desafio.cadastroLivros.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    public List<Livro> findByDisponivelTrue();
}
