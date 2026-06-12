package desafio.cadastroLivros.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "anoPublicado")
    private LocalDate anoPublicado;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "disponivel")
    private boolean disponivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(LocalDate anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
